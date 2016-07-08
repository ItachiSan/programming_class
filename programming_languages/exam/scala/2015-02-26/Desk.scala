import scala.util.parsing.combinator._
import scala.collection.mutable.HashMap
import scala.io.Source

class DeskParser extends JavaTokenParsers {
	val values = new HashMap[String, Int]()
	def program = rep1(evaluation)

	def evaluation = "print" ~> expression <~ "where" ~> assignments ^^ {
		// Solve the expression
		case list =>
		var result = 0
		list foreach {
			// Desk allows only sums
			case (x: (() => Int)) => result = result + x()
			//case (x: Int) => result += x
		}
		println(result)
		println(values)
		values.clear
		//println(list)
	}

/*
We need to return a function, as Scala assigns the value after evaluating
'assignments', so if we get the value from the HashMap too early we will fail
*/
	def expression = rep1sep((variable | value), "+")
	def variable = ident ^^ {
		//v => values(v)
		v => (() => values(v))
	}
	def value = wholeNumber ^^ { case x => (() => x.toInt) }

	def assignments = rep1sep(declare, ",")
	def declare = ident ~ ("=" ~> wholeNumber) ^^ {
		case x ~ v => values(x) = v.toInt //; println(x + "=" + v)
	}
}

object DeskEvaluator {
	def main(args: Array[String]) {
		val p = new DeskParser()
		args foreach {
			case a =>
				val s = Source.fromFile(a).mkString
				p.parseAll(p.program, s) match {
					case p.Success(_, _) =>
					case p.Error(err, rest) => println("Error: " + err + "\nResting: " + rest.source.toString)
					case p.Failure(err, rest) => println("Failure: " + err + "\nResting: " + rest.source.toString)
				}
		}
	}
}
