import scala.util.parsing.combinator._

// Implement the internal grammar
abstract class Expr { // Abstract class
	def eval: Int
}

case class Number(n: Int) extends Expr {
	// A class representing a number.
	def eval = n
	override def toString = n.toString
}

case class Plus(a: Expr, b: Expr) extends Expr {
	def eval = a.eval + b.eval
	override def toString = "(" + a.toString + " + " + b.toString + ")"
}

case class Minus(a: Expr, b: Expr) extends Expr {
	def eval = a.eval - b.eval
	override def toString = "(" + a.toString + " - " + b.toString + ")"
}

case class Times(a: Expr, b: Expr) extends Expr {
	def eval = a.eval * b.eval
	override def toString = "(" + a.toString + " * " + b.toString + ")"
}

case class Divide(a: Expr, b: Expr) extends Expr {
	def eval = a.eval / b.eval
	override def toString = "(" + a.toString + " / " + b.toString + ")"
}

// Define the parser
class ArithmeticParser extends JavaTokenParsers {
	// Each expression can be a subexpression or a simple number
	def expression = subexpr | number
	def number = decimalNumber ^^ {n => Number(n.toInt)}
	def subexpr: Parser[Expr] = "(" ~> expression ~ operator ~ expression <~ ")" ^^ {
		case a ~ op ~ b => op match {
			case "+" => Plus(a,b)
			case "-" => Minus(a,b)
			case "*" => Times(a,b)
			case "/" => Divide(a,b)
		}
	}
	def operator = "+" | "-" | "*" | "/"
}

// Define the step by step solver
object Solver {
	def step(e: Expr) : Expr = {
		e match {
			// If it is a number, keep it (final solution)
			case Number(x) => Number(x)
			// If you can solve by a single step, do it
			case Plus(Number(a),Number(b)) => Number(e.eval)
			case Minus(Number(a),Number(b)) => Number(e.eval)
			case Times(Number(a),Number(b)) => Number(e.eval)
			case Divide(Number(a),Number(b)) => Number(e.eval)
			// Else, recur.
			case Plus(a,b) => Plus(step(a),step(b))
			case Minus(a,b) => Minus(step(a),step(b))
			case Times(a,b) => Times(step(a),step(b))
			case Divide(a,b) => Divide(step(a),step(b))
		}
	}
	def solve (e: Expr) {
		println(e)
		e match {
			case Number(_) => ()
			case expr => solve(step(expr))
		}
	}
}

// Finally, define the CLI parser.
object StepByStepEvaluator {
	def main(args: Array[String]) {
		val p = new ArithmeticParser()
		args foreach {
			s => p.parseAll(p.expression, s) match {
				case p.Success(expr,_) => Solver.solve(expr); println
				case x => println(x)
			}
		}
	}
}
