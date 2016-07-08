import scala.util.parsing.combinator._
import scala.io.Source

import java.io.{File,FileInputStream,FileOutputStream}

class LogParser extends JavaTokenParsers {
	def log_program = rep1(log_task)
	def log_task = "task" ~> ident ~ ( "{" ~> rep1(op) <~ "}" ) ^^ {
		case name ~ ops =>
			println("Task " + name)
			var task_number = 1
			for (t <- ops) {
				println("\t[op" + task_number + "] " + t)
				task_number += 1
			}
	}
	def op = remove | rename | merge | backup
	def remove = "remove" ~> filename ^^ {
		case s => LogExecutor.remove(s)
	}
	def rename = "rename" ~> filename ~ filename ^^ {
		case f1 ~ f2 => LogExecutor.rename(f1, f2)
	}
	def merge = "merge" ~> filename ~ filename ~ filename ^^ {
		case f1 ~ f2 ~ f3 => LogExecutor.merge(f1, f2, f3)
	}
	def backup = "backup" ~> filename ~ filename ^^ {
		case f1 ~ f2 => LogExecutor.backup(f1, f2)
	}
	def filename = stringLiteral ^^ { s => s.replaceAll("\"", "") }
}

object LogExecutor {
	def remove(f: String) = {
		try {
			new File(f).delete
		} catch {
			case e: Exception => false
		}
	}
	def rename(f1: String, f2: String) = {
		try {
			new File(f1).renameTo(new File(f2))
		} catch {
			case e: Exception => false
		}
	}
	def merge(f1: String, f2: String, f3: String) = {
		try {
			val s1 = Source.fromFile(f1).mkString
			val s2 = Source.fromFile(f2).mkString
			val s3 = s1 + "\n" + s2
			new FileOutputStream(new File(f3)).write(s3.getBytes())
			true
		} catch {
			case e: Exception => false
		}
	}
	def backup(f1: String, f2: String) = {
		try {
			val s = Source.fromFile(f1).mkString
			new FileOutputStream(new File(f2)).write(s.getBytes())
			true
		} catch {
			case e: Exception => false
		}
	}
}

object LogLangEvaluator {
	def main(args: Array[String]) {
		val p = new LogParser
		args.foreach {
			f =>
				p.parseAll(p.log_program, Source.fromFile(f).mkString) match {
					case p.Success(_, _) =>
					case p.Error(err, rest) =>
						println("Error parsing '" + err + "'\nRemaining: " + rest.source.toString)
					case p.Failure(err, rest) =>
						println("Failure parsing '" + err + "'\nRemaining: " + rest.source.toString)
				}
		}
	}
}
