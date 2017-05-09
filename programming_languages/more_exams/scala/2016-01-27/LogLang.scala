import scala.util.parsing.combinator._
import java.io.{File,FileOutputStream}
import scala.io.Source

class LogLangParser extends JavaTokenParsers {
	// Define the program structure
	def program = rep1(task)
	// Define the task structure
	def task = "task" ~> ident ~ ("{" ~> rep1(operation) <~ "}") ^^ {
		// During the parsing, the operations were already done.
		case name ~ ops =>
			println("Task " + name)
			var counter = 1
			ops foreach {
				x =>
					// Print the result of each operation.
					println("\t[op" + counter + "] " + x)
					counter += 1
			}
	}
	// Define the possible operations.
	def operation = remove | rename | merge | backup
	// Make the file names correct for the application.
	def filename = stringLiteral ^^ {_.replaceAll("\"","")}
	// Define what the operations do.
	def remove = "remove" ~> filename ^^ {
		f => try {
			new File(f).delete
		} catch {
			case e: Exception => false
		}
	}
	def rename = "rename" ~> filename ~ filename ^^ {
		case x ~ y => try {
			new File(x).renameTo(new File(y))
		} catch {
			case e: Exception => false
		}
	}
	def merge = "merge" ~> filename ~ filename ~ filename ^^ {
		case x ~ y ~ z => try {
			val content = Source.fromFile(x).mkString + Source.fromFile(y).mkString
			new FileOutputStream(new File(z)).write(content.getBytes())
			true
		} catch {
			case e: Exception => false
		}
	}
	def backup = "backup" ~> filename ~ filename ^^ {
		case x ~ y => try {
			new FileOutputStream(new File(y)).write(
				Source.fromFile(x).mkString.getBytes()
			)
			true
		} catch {
			case e: Exception => false
		}
	}
}

object LogLangEvaluator {
	def main(args: Array[String]) {
		val p = new LogLangParser
		args foreach {
			f => p.parseAll(p.program, Source.fromFile(f).mkString) match {
				case p.Success(_,_) =>
				case x => println(x)
			}
		}
	}
}
