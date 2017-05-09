import scala.util.parsing.combinator._
import scala.collection.mutable._
import scala.io.Source

class ArnoldCParser (
		var stack: Stack[Int],
		var table: HashMap[String,Int]
	) extends JavaTokenParsers {
	// Every ArnoldC program is like this
	def arnoldc_program = "IT'S" ~> "SHOW" ~> "TIME" ~> arnoldc_body <~
		"YOU" <~ "HAVE" <~ "BEEN" <~ "TERMINATED"
	// Every ArnoldC program uses the allowed statements
	def arnoldc_body: Parser[Any] = rep(statement)
	def statement = print | var_def | var_ass | conditional | loop
	// Print statement
	def print = "TALK" ~> "TO" ~> "THE" ~> "HAND" ~> (variable | stringLiteral) ^^
		{println(_)}
	// Variable handling common definitions
	def intValue = wholeNumber ^^ {_.toInt}
	def variable = ident ^^ {table(_)}
	def possibleValue = intValue | variable
	def initialValue = intValue | variable ^^ {stack.push(_)}
	// Variables declaration
	def var_def = "HEY" ~> "CHRISTMAS" ~> "TREE" ~> ident ~ 
		( "YOU" ~> "SET" ~> "US" ~> "UP" ~> intValue ) ^^
		{case v ~ n => table(v) = n}
	// Variables assignment
	def var_ass = "GET" ~> "TO" ~> "THE" ~> "CHOPPER" ~> ident <~
		("HERE" ~> "IS" ~> "MY" ~> "INVITATION" ~> initialValue) <~
		operations <~ "ENOUGH" <~ "TALK" ^^ {table(_) = stack.pop}
	// Arithmetic operations
	def arithmetic_ops = plus | minus | times | divide
	def plus = "GET" ~> "UP" ~> possibleValue ^^
		{n => stack.push(stack.pop + n)}
	def minus = "GET" ~> "DOWN" ~> possibleValue ^^
		{n => stack.push(stack.pop - n)}
	def times = "YOU'RE" ~> "FIRED" ~> possibleValue ^^
		{n => stack.push(stack.pop * n)}
	def divide = "HE" ~> "HAD" ~> "TO" ~> "SPLIT" ~> possibleValue ^^
		{n => stack.push(stack.pop / n)}
	// Logic operations
	def logic_ops = equal | greater | or | and
	def equal = "YOU" ~> "ARE" ~> "NOT" ~> "YOU" ~> "YOU" ~> "ARE" ~> "ME" ~>
		possibleValue ^^
		{n => if (stack.pop == n) stack.push(1) else stack.push(0)}
	def greater = "LET" ~> "OFF" ~> "SOME" ~> "STEAM" ~> "BENNET" ~>
		possibleValue ^^
		{n => if (stack.pop > n) stack.push(1) else stack.push(0)}
	def or = "CONSIDER" ~> "THAT" ~> "A" ~> "DIVORCE" ~> possibleValue ^^
		{n => stack.push(toOne(stack.pop * n))}
	def and = "KNOCK" ~> "KNOCK" ~> possibleValue ^^
		{n => stack.push(toOne(stack.pop + n))}
	def toOne (n: Int) = if (n != 0) 1 else 0
	// Operations can be arithmetic or logic ones
	def possible_ops = arithmetic_ops | logic_ops
	def operations = rep1(possible_ops)
	// Block, used from conditionals and loops
	//def block = """\[.*?\]""".r ^^ {s => s.substring(1, s.length - 1)}
	def block = """\[[^\]]*\]""".r ^^ {s => s.substring(1, s.length - 1)}
	// Conditionals
	def conditional = "BECAUSE" ~> "I'M" ~> "GOING" ~> "TO" ~> "SAY" ~>
		"PLEASE" ~> possibleValue ~ block ~ ("BULLSHIT" ~> block <~ "YOU" <~
		"HAVE" <~ "NO" <~ "RESPECT" <~ "FOR" <~ "LOGIC") ^^ {
		case v ~ b1 ~ b2 =>
			if(v != 0)
				parseAll(arnoldc_body, b1)
			else
				parseAll(arnoldc_body, b2)
		}
	// Loop
	def loop = "STICK" ~> "AROUND" ~> ident ~ block <~ "CHILL" ^^
		{case v ~ b => while (table(v) != 0) parseAll(arnoldc_body, b)}
}

object ArnoldCEvaluator {
	def main (args: Array[String]) {
		val p = new ArnoldCParser(new Stack[Int](), new HashMap[String, Int]())
		args foreach { f =>
			val src = Source.fromFile(f)
			val s = src.mkString
			src.close()
			p.parseAll(p.arnoldc_program, s) match {
				case p.Success(_,_) =>
				case x => println(x)
			}
		}
	}
}
