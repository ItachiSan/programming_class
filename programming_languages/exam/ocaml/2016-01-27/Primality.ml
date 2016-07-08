(* Create easily a list of numbers, starting from s and stopping at n *)
let numbers n s=
	let rec numbers' n i =
	match i with
		| a when a < n -> a :: numbers' n (a+1)
		| _ -> []
	in
		(* We start from 2, as it is the first possible divisors *)
		numbers' n s

(* Generate all primes numbers up to n *)
(*
let primes n =
	let prime_check n =
		match trialdivision n with
			| true -> [n]
			| false -> []
	in
	let rec primes' list =
		match list with
			| [] -> []
			| h :: tl -> (prime_check h) @ (primes' tl)
	in
		primes' (numbers n 2)
*)

(* Check if a number is prime, using trial division *)
let trialdivision n =
	let rec division_check n list =
		match list with
			| [] -> []
			| h :: tl when n mod h == 0 -> h :: division_check n tl
			| h :: tl -> division_check n tl
	in
		match division_check n (numbers n 2) with
			| [] -> true
			| _ -> false


let lucaslehmer n =
	let lucaslehmer_residue n =
		let rec pow2 n i =
			match int_of_float (2.0 ** (float_of_int i)) with
				| a when a >= n -> i
				| a -> pow2 n (i+1)
		in
		let rec lucaslehmer_residue' n p i res =
			match i with
				| x when x == (p-2) -> Printf.printf "LLR %d: %d -> %d\n" i res (res mod n); res mod n
				| x -> Printf.printf "LLR %d: %d\n" i res;
					lucaslehmer_residue' n p (i+1) (((res*res) - 2))
		in
			lucaslehmer_residue' n (pow2 n 0) 0 4
	in
		match lucaslehmer_residue n with
			| 0 -> true
			| _ -> false


let is_prime n =
	match n with
		| a when a <= 10000 -> trialdivision n
		| a when a >= 10000 and a <= 524287 -> lucaslehmer n
		| a -> trialdivision n

(*
trialdivision
lucaslehmer
littlefermat
*)
