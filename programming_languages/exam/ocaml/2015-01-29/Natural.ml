module Natural =
	struct

		(* Datatypes definitions *)
		type natural = Succ of natural | Zero
		exception NegativeNumber
		exception DivisionByZero

		(* Conversion functions *)
		let rec eval n =
			match n with
				| Zero -> 0
				| Succ(x) -> 1 + (eval x)
		let rec convert n =
			match n with
				| 0 -> Zero
				| n -> Succ((convert (n-1)))

		let rec ( + ) a b =
			match (a, b) with
			| Zero, Zero -> Zero
			| Succ(x), Zero -> Succ(x)
			| Zero, Succ(y) -> Succ(y)
			| Succ(x), Succ(y) -> (Succ(Succ(x))) + y

		let rec ( - ) a b =
			match (a, b) with
			| Zero, Zero -> Zero
			| Succ(x), Zero -> Succ(x)
			| Zero, Succ(y) -> raise NegativeNumber
			| Succ(x), Succ(y) -> x - y

		let rec ( * ) a b =
			match (a, b) with
			| Zero, Zero -> Zero
			| Succ(x), Zero -> Zero
			| Zero, Succ(y) -> Zero
			| Succ(x), Succ(y) -> Succ(x) + (Succ(x) * y)

		let rec ( / ) a b =
			match (a, b) with
			| _, Zero -> raise DivisionByZero
			| Zero, _ -> Zero
			| Succ(x), Succ(y) ->
				try
					Succ(Zero) + ((Succ(x) - Succ(y)) / Succ(y))
				with NegativeNumber ->
					Zero
	end

module N = (Natural : NaturalI.NaturalI)
