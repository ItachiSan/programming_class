(* Create list of integers that goes from 'low' to 'high' *)
let rec create_int_list low high =
	match low with
		| n when n > high -> []
		| n -> n :: create_int_list (low + 1) high

(* Check if a number is prime *)
let is_prime x =
	let n = create_int_list 2 (x - 1) in
	let rec check x l =
		match l with
		| [] -> true
		| h :: t -> (x mod h != 0) && (check x t)
	in check x n

(* Create a list of prime number *)
let create_primes_list low high = List.filter (is_prime) (create_int_list low high)

(* Generate the Goldbach list *)
let goldbach_list low high =
	let even_list = List.filter (fun x -> x mod 2 = 0) (create_int_list low high) in
	let primes_list = create_primes_list 2 high in
	let rec search evens primes1 primes2 primes_full =
		match evens with
			| [] -> []
			| h :: t ->
				match primes1, primes2 with
					| [], _ -> (h,(0,0)) :: (search t primes_full primes_full primes_full)
					| h1 :: t1, [] -> (search evens t1 primes_full primes_full)
					| h1 :: t1, h2 :: t2 ->
						if (h1 + h2 = h) then
							(h,(h1,h2)) :: (search t primes_full primes_full primes_full)
						else
							(search evens primes1 t2 primes_full)
	in
		search even_list primes_list primes_list primes_list
