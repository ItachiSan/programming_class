import scala.util.parsing.combinator._
import scala.io.Source

class CSVParser extends JavaTokenParsers {
	override val skipWhitespace = false
	override val whiteSpace = """[ \t]""".r

	def string = """[^,\n\r\"]+""".r ^^ { _.trim }
	def quotedString = whiteSpace.* ~> "\"" ~> """[^\n\r\"]*""".r <~ "\"" <~ whiteSpace.* ^^ { _.toString }
	def empty = whiteSpace.+ ^^ { case _ => "" } 
	def field = quotedString | string | empty ^^ {case str => str}

	def row = rep1sep(field, ",") <~ """\r""".? <~ "\n" ^^ {case list => list}
	def head = row
	def doc = head ~ rep1(row) ^^ {case h ~ l => h :: l}
}

class CSVParserNico extends JavaTokenParsers {
	override val skipWhitespace = false
	override val whiteSpace = """[ \t]""".r

	def title = whiteSpace.* ~> "\"" ~> """[^\n\r\"]*""".r <~ "\"" <~ whiteSpace.* ^^ { _.toString }
	def string = """[^,\n\r\"]+""".r ^^ { _.trim }
	def empty = whiteSpace.+ ^^ { case _ => "" }

	def field = title | string | empty ^^ { case str => str }

	def header = row
	def row = rep1sep(field, ",") <~ """\r""".? <~ "\n" ^^ { case list => list }

	def doc = header ~ rep1(row) ^^ {
		case head ~ list => head :: list
	}
}

object CSVFormatter {
	def format(list: List[List[String]]): String = {
		val maxLengths = list.map(_.map(_.length)).transpose.map(_.max)

		val formattedString = list.map {
			// We are handling the lines
			(maxLengths, _).zipped.map {
				(length, string) =>
					val emptySpace = length - string.length
					" " + string + (" " * emptySpace) + " "
			}.mkString("|", "|", "|")
		}

		val dashLine = "-" * (maxLengths.map(_ + 2).sum + maxLengths.length + 1) + "\n"
		formattedString match {
			case Nil => ""
			case head :: tail => dashLine + head + "\n" + tail.mkString(dashLine, "\n", "\n" + dashLine)
		}
	}
}

object CSVParserCLI {
	def main(args: Array[String]) {
		val parser = new CSVParser
		args.foreach  {
			filename =>
				val f = Source.fromFile(filename)
				val s = f.mkString
				f.close
				parser.parseAll(parser.doc, s) match {
					case parser.Success(result, _) => println(CSVFormatter.format(result))
					case parser.Error(message, _) => println("Error: " + message)
					case parser.Failure(message, _) => println("Failure: " + message)
				}
		}
	}
}
