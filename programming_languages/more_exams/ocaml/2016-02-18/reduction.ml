module ArithExpr =
	struct

	(* Internal datatype to handle the expressions. *)
	type expression = Number of float
		| Plus of expression * expression
		| Minus of expression * expression
		| Times of expression * expression
		| Divide of expression * expression

	(* Return a string for internal types *)
	let rec string_of_expr expr =
		match expr with
		| Number(n) 	-> string_of_float n
		| Plus(a,b) 	-> "(" ^ (string_of_expr a) ^ " + " ^ (string_of_expr b) ^ ")"
		| Minus(a,b) 	-> "(" ^ (string_of_expr a) ^ " - " ^ (string_of_expr b) ^ ")"
		| Times(a,b) 	-> "(" ^ (string_of_expr a) ^ " * " ^ (string_of_expr b) ^ ")"
		| Divide(a,b) 	-> "(" ^ (string_of_expr a) ^ " / " ^ (string_of_expr b) ^ ")"

	(* Execute a step of the solution *)
	let rec step expr =
		match expr with
		| Number(n)		-> Number(n)
		| Plus(Number(a),Number(b))		-> Number(a +. b)
		| Minus(Number(a),Number(b))	-> Number(a -. b)
		| Times(Number(a),Number(b))	-> Number(a *. b)
		| Divide(Number(a),Number(b))	-> Number(a /. b)
		| Plus(a,b)		-> Plus(step(a),step(b))
		| Minus(a,b)	-> Minus(step(a),step(b))
		| Times(a,b)	-> Times(step(a),step(b))
		| Divide(a,b)	-> Divide(step(a),step(b))

	(* Parse a string in Polish notation and return data in an 'expression'. *)
	let parse string =
		let rec parse' string index =
			match string.[index] with
			| '+' ->
				let a, i1 = parse' string (index + 1) in
				let b, i2 = parse' string (i1 + 1) in
				Plus(a,b), i2
			| '-' ->
				let a, i1 = parse' string (index + 1) in
				let b, i2 = parse' string (i1 + 1) in
				Minus(a,b), i2
			| '*' ->
				let a, i1 = parse' string (index + 1) in
				let b, i2 = parse' string (i1 + 1) in
				Times(a,b), i2
			| '/' ->
				let a, i1 = parse' string (index + 1) in
				let b, i2 = parse' string (i1 + 1) in
				Divide(a,b), i2
			| n -> Number(float_of_int ((int_of_char n) - 48)), index
		in
		fst (parse' string 0)

	(* Combine 'parse' and 'step' togheter *)
	let print_evaluation string =
		let rec print_step expression =
			print_endline (string_of_expr expression);
			match expression with
			| Number(n) -> ()
			| expr -> print_step (step expr)
		in
			print_step (parse string)

	end
