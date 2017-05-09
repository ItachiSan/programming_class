module Natural : NaturalI.NaturalI =
	struct
		(* Type definitions *)
		type natural = Successive of natural | Zero
		exception NegativeNumber
		exception DivisionByZero

		(* Functions for conversion from 'natural' to 'int' and viceversa. *)
		let rec convert n =
			match n with
			| 0 -> Zero
			| _ -> Successive((convert (n - 1)))
		let rec eval natural =
			match natural with
			| Zero -> 0
			| Successive(n) -> 1 + (eval n)

		(* Operators override for the 'natural' datatype *)
		let rec ( + ) n1 n2 =
			match n2 with
			| Zero -> n1
			| Successive(n) -> ( + ) (Successive(n1)) n

		let rec ( - ) n1 n2 =
			match n1, n2 with
			| n, Zero -> n
			| Zero, _ -> raise NegativeNumber
			| Successive(a), Successive(b) -> ( - ) a b

		let rec ( * ) n1 n2 =
			match n1, n2 with
			| Zero, _ -> Zero
			| _, Zero -> Zero
			| _, Successive(n) -> n1 + (( * ) n1 n)

		let rec ( / ) n1 n2 =
			match n1, n2 with
			| Zero, _ -> Zero
			| _, Zero -> raise DivisionByZero
			| Successive(a), Successive(b) ->
				try
					Successive(Zero) + (( / ) (n1 - n2) n2)
				with
					NegativeNumber -> Zero

	end

module N = Natural
