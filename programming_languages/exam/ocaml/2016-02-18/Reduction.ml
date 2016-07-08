module ArithExpr =
	struct

	(* Datatype to handle expressions *)
	type expr = Plus of expr * expr |
		Minus of expr * expr |
		Times of expr * expr |
		Divide of expr * expr |
		Number of float

	(* Return normal results of expressions *)
	let rec combine e =
		match e with
			| Number(x) -> Number(x)
			| Plus(Number(x),Number(y)) -> Number(x+.y)
			| Plus(x,y) -> Plus((combine x),(combine y))
			| Minus(Number(x),Number(y)) -> Number(x-.y)
			| Minus(x,y) -> Minus((combine x),(combine y))
			| Times(Number(x),Number(y)) -> Number(x*.y)
			| Times(x,y) -> Times((combine x),(combine y))
			| Divide(Number(x),Number(y)) -> Number(x/.y)
			| Divide(x,y) -> Divide((combine x),(combine y))

	let rec tostring e =
		match e with
			| Number(x) -> string_of_float x
			| Plus(x,y) -> "( " ^ (tostring x) ^ " + " ^ (tostring y) ^ " )"
			| Minus(x,y) -> "( " ^ (tostring x) ^ " - " ^ (tostring y) ^ " )" 
			| Times(x,y) -> "( " ^ (tostring x) ^ " * " ^ (tostring y) ^ " )"
			| Divide(x,y) -> "( " ^ (tostring x) ^ " / " ^ (tostring y) ^ " )"

	let print_evaluation s =
		let rec calculation e =
			print_endline(tostring e);
			match e with
				| Number(x) -> ()
				| e -> calculation (combine e)
		in
		let rec parse s n =
			match s.[n] with
			| '+' -> 
				let x, pos1 = (parse s (n+1)) in
				let y, pos2 = (parse s (pos1+1)) in
				Plus(x,y), pos2
			| '-' -> 
				let x, pos1 = (parse s (n+1)) in
				let y, pos2 = (parse s (pos1+1)) in
				Minus(x,y), pos2
			| '*' -> 
				let x, pos1 = (parse s (n+1)) in
				let y, pos2 = (parse s (pos1+1)) in
				Times(x,y), pos2
			| '/' -> 
				let x, pos1 = (parse s (n+1)) in
				let y, pos2 = (parse s (pos1+1)) in
				Divide(x,y), pos2
			| x -> Number(float_of_int((int_of_char x) - 48)), n
		in
			calculation (fst (parse s 0))

	end
