(* Normal trial-division algorithm. *)
let trialdivision n =
	let rec create_int_list low high =
		match low with
		| x when x > high -> []
		| x -> x :: (create_int_list (low + 1) high)
	in
	let divisors = List.filter (fun x -> (n mod x) = 0) (create_int_list 2 (n - 1))
	in
	print_string "Trial-Division's Primality Test";
	(List.length divisors) = 0

(* Calculate the power of a number, given base and exponent. E.g. 2 ^ 5 *)
let pow base exp =
	let rec pow' base exp counter =
		match counter with
		| n when n >= exp -> 1
		| n -> base * (pow' base exp (counter + 1))
	in
		pow' base exp 0

(* Lucas-Lehmer's test, the correct one. *)
let lucaslehmer_correct n =
	(* The Mersenne number related to n *)
	let m_p = ((pow 2 n) - 1) in
	let rec find_s limit counter solution =
		(* (print_endline ("s: " ^ (string_of_int solution) ^ ", p: " ^ (string_of_int n))); *)
		match counter with
			| n when n >= limit -> solution
			| n -> find_s limit (counter + 1) (((solution * solution) - 2) mod m_p) 
	in
		(* (print_endline (string_of_int(find_s (n - 2) 0 4))); *)
		(find_s (n - 2) 0 4) = 0

(*
The professor version seems to assume that the input is a Mersenne number.
Avoid problem of memory assuming this.
*)
let lucaslehmer n =
	(* We assume n is a Mersenne number. *)
	let rec find_s limit counter solution =
		match counter with
			| x when x >= limit -> solution
			| x -> find_s limit (counter + 1) (((solution * solution) - 2) mod n)
	in
	let p = int_of_float ((log (float_of_int (n + 1))) /. (log 2.)) in
		print_string "Lucas-Lehmer's Primality Test  ";
		(find_s (p - 2) 0 4) = 0

(* Modular exponentation, else Fermat suicide itself... *)
let modpow base exp rem =
	let rec modpow' base exp solution =
		match exp with
		| 0 -> solution
		| n -> modpow' base (exp - 1) ((solution * base) mod rem)
	in
		modpow' base exp 0

(* Little Fermat's test. *)
let littlefermat n =
	Random.self_init;
	print_string "Little Fermat's Primality Test ";
	let rec create_rand_int_list low high bound =
		match low with
		| x when x > high -> []
		| x -> (Random.int bound) :: (create_rand_int_list (low + 1) high bound)
	in
	let list = List.filter (fun x -> (modpow x (n - 1) n) != 1) (create_rand_int_list 1 128 32)
	in
		match list with
		| [] -> true
		| _ -> false

(* The function required to switch between different prime tests functions. *)
let is_prime n =
	match n with
		| a when a <= 10000 -> trialdivision n
		| a when (a >= 10001 && a <= 524287) -> lucaslehmer n
		| a -> littlefermat n
