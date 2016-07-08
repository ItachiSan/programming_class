import scala.util.parsing.combinator._

// Implement the grammar
abstract class Expr {
	def eval: Int
}
case class Number(x: Int) extends Expr {
	def eval = x
	override def toString = "" + x
}
case class Plus(x: Expr, y: Expr) extends Expr {
	def eval = x.eval + y.eval
	override def toString = "(" + x.toString + " + " + y.toString + ")"
}
case class Minus(x: Expr, y: Expr) extends Expr {
	def eval = x.eval - y.eval
	override def toString = "(" + x.toString + " - " + y.toString + ")"
}
case class Times(x: Expr, y: Expr) extends Expr {
	def eval = x.eval * y.eval
	override def toString = "(" + x.toString + " * " + y.toString + ")"
}
case class Divide(x: Expr, y: Expr) extends Expr {
	def eval = x.eval / y.eval
	override def toString = "(" + x.toString + " / " + y.toString + ")"
}

class StepByStepParser extends JavaTokenParsers {
	def expression = element
	def element = exp | number
	def operator = "+" | "-" | "/" | "*"
	def exp : Parser[Expr] = "(" ~> element ~ operator ~ element <~ ")" ^^ {
		case x ~ op ~ y =>
			op match {
				case "+" => Plus(x,y)
				case "-" => Minus(x,y)
				case "*" => Times(x,y)
				case "/" => Divide(x,y)
			}
	}
	def number = decimalNumber ^^ {case x => Number(x.toInt)}
}

object StepByStepSolver {
	def combine(e: Expr) : Expr = {
		e match {
			case Number(x) => Number(x)
			case Plus(Number(x),Number(y)) => Number(e.eval)
			case Minus(Number(x),Number(y)) => Number(e.eval)
			case Times(Number(x),Number(y)) => Number(e.eval)
			case Divide(Number(x),Number(y)) => Number(e.eval)
			case Plus(x, y) => Plus(combine(x), combine(y))
			case Minus(x, y) => Minus(combine(x), combine(y))
			case Times(x, y) => Times(combine(x), combine(y))
			case Divide(x, y) => Divide(combine(x), combine(y))
		}
	}
	def solve(e: Expr) {
		println(e.toString)
		e match {
			case Number(x) => ()
			case x => solve(combine(x))
		}
	}
}

object StepByStepEvaluator {
	def main(args: Array[String]) {
		val p = new StepByStepParser()
		args foreach {
			case a => p.parseAll(p.exp, a) match {
				case p.Success(result, _) => StepByStepSolver.solve(result); println
				case p.Error(err, rest) => println("Error: " + err + ", remaining " + rest)
				case p.Failure(err, rest) => println("Failure: " + err + ", remaining " + rest)
			}
		}
	}
}
