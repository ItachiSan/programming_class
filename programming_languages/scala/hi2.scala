object Main2 {
	def value_sum(list: List[Int]): Int = {
		var sum = 0
		for (i <- list)
			sum += i
		return sum
	} 
	def main(args: Array[String]): Unit = {
		println("Hello world!")
		for (i <- args)
			println("Sum of the integers up to " + i + " is " + value_sum(List.range(1,i.toInt)))
		
	}
	//val main = (args: Array[String]) => {println("Hello world!")}
}
