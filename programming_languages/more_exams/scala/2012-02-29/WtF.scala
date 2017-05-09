import scala.io.Source
import scala.util.parsing.combinator._
import scala.collection.mutable._ // HashTable

class WtFParser(
		var stack: Stack[Int],
		var fun_table: HashMap[Char, (Int,String)],
		var args_array: Array[Int]
	) extends JavaTokenParsers {
	// Program structure
	def wtf_program = program_head ~ program_body
	// Each part has multiple sub-components
	def program_head = rep(fun_def)
	def program_body = rep1(expr)
	// Description of the header part
	def fun_def = "def" ~> fun_name ~ args_number ~ ("=" ~> """.*\n""".r ) ^^ {
		case name ~ number ~ function =>
			fun_table(name) = (number,function)
	}
	def fun_name = """[A-Z]""".r ^^ {s => s.charAt(0)} // Dirty way to have a Char
	def args_number = decimalNumber ^^ {n => n.toInt}
	// We miss the args reference
	def variable = "$" ~> decimalNumber ^^ {n => stack.push(args_array(n.toInt - 1))}
	// Define allowed operators
	def operator = "0" ^^ {_ => stack.push(0)} |
		"+" ^^ {_ => stack.push(stack.pop + 1)} |
		"-" ^^ {_ => stack.push(stack.pop - 1)} |
		"!" ^^ {_ => println(stack.pop)}
	// Define conditionals
	def conditional = "?" ~> block ~ (":" ~> block) ^^ {
		case b1 ~ b2 =>
		if (stack.pop == 0)
			parseAll(program_body, b1)
		else
			parseAll(program_body, b2)
	}
	def block = """\[.*?\]""".r ^^ {s => s.substring(1, s.length - 1)}
	// Define the function call
	def fun_call = fun_name ^^ {
		c =>
			val argc = fun_table(c)._1
			var argv = new Array[Int](argc)
			(argc - 1) to 0 by -1 foreach
				(n => argv(n) = stack.pop)
			val parser = new WtFParser(stack, fun_table, argv)
			parser.parseAll(parser.program_body, fun_table(c)._2)
	}
	// So, descrive what an expression is
	def expr: Parser[Any] = operator | variable | conditional | fun_call
}

object WtFEvaluator {
	def main (args: Array[String]) = {
		val parser = new WtFParser(
			new Stack[Int](),
			new HashMap[Char,(Int,String)](),
			new Array[Int](10)
		)
		args foreach {
			file =>
				var lines = Source.fromFile(file).mkString
				parser.parseAll(parser.wtf_program, lines) match {
					case parser.Success(_,_) =>
					case x => println(x)
				}
		}
	}
}
