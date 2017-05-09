import scala.util.parsing.combinator._
import scala.io.Source

class CSVParser extends JavaTokenParsers {
	// The header is a line, only with definition fields.
	def header = line
	// Lines are a bunch of fields divided by ','.
	def line = rep1sep(element, ",") <~ "\n"
	// Sometimes, an element is empty...
	def element = (quotedFull | full | empty) ^^ {_.replaceAll("\"","")}
	def quotedFull =  whiteSpace.* ~> "\"" ~> """[^\n\r\"]+""".r <~ "\"" <~ whiteSpace.*
	def full = """[^,\n\r]+""".r ^^ {_.trim}
	def empty = whiteSpace.+ ^^ {_ => ""}
	// If we skip white spaces, we would not detect empty fields.
	override val skipWhitespace = false
		// A CSV file usually uses 1 line as header and the others as content.
	def csv = header ~ rep1(line) ^^ {
		// Format the map properly
		case head ~ lines =>
		// Create the map (list of lists) of strings.
		val content = head :: lines
		/*
		Now, find the greatest length considering columns
		To do so, we map 'length' to each element, transpose the resulting map
		and get the maximum value.
		*/
		val maxLengths = content.map(_.map(_.length)).transpose.map(_.max)
		// Format the map to a proper list of strings.
		val formattedContent = content map {
			(_, maxLengths).zipped.map {
				(c, l) =>
					// 'l' is maximum length. Detect number of white spaces needed.
					def toFill = l - c.length
					// Give back a proper string.
					" " + c + (" " * toFill) + " "
			}.mkString("|","|","|")
			// Now we have a list of strings...
		} match {
			case Nil => ""
			case h :: tl =>
			// Create the line for splitting head and lines
			val divider_length = (maxLengths.map(_ + 2).sum + maxLengths.length + 1)
			val divider = "-" * divider_length + "\n"
			divider + h + tl.mkString(
				"\n" + divider,
				"\n",
				"\n" + divider
			)
		}
		formattedContent
	}
}

object CSVParserCLI {
	def main(args: Array[String]) {
		val p = new CSVParser
		args foreach { x =>
			p.parseAll(p.csv, Source.fromFile(x).mkString) match {
				case p.Success(r,_) => println(r)
				case x => println(x)
			}
		}
	}
}
