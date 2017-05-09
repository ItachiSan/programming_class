(* Remove a specific element from a list *)
let rec remove elem list =
	match list with
		| [] -> []
		| h :: l when h = elem -> remove elem l
		| h :: l -> h :: (remove elem l)

(* Functions to handle strings *)
let first_of_str s = s.[0]
let last_of_str s = s.[(String.length s) - 1]

(* Remove already used countries from the countries list *)
let remove_country hashtbl country =
	let c = first_of_str country in
		Hashtbl.replace hashtbl c (remove country (Hashtbl.find hashtbl c));
		hashtbl;;

(* The initial countries list *)
let countries =
	let c = Hashtbl.create 26 in
	Hashtbl.add c 'a' ["albania"; "andorra"; "austria"];
	Hashtbl.add c 'b'
		["belarus"; "belgium"; "bosnia and herzegovina"; "bulgaria"];
	Hashtbl.add c 'c' ["croatia"; "czech republic"];
	Hashtbl.add c 'd' ["denmark"];
	Hashtbl.add c 'e' ["estonia"];
	Hashtbl.add c 'f' ["finland"; "france"];
	Hashtbl.add c 'g' ["germany"; "greece"];
	Hashtbl.add c 'h' ["hungary"];
	Hashtbl.add c 'i' ["iceland"; "ireland"; "italy"];
	Hashtbl.add c 'j' [];
	Hashtbl.add c 'l'
		["latvia"; "liechtenstein"; "lithuania"; "luxembourg"];
	Hashtbl.add c 'k' [];
	Hashtbl.add c 'm'
		["macedonia"; "malta"; "moldova"; "monaco"; "montenegro"];
	Hashtbl.add c 'n' ["netherlands"; "norway"];
	Hashtbl.add c 'o' [];
	Hashtbl.add c 'p' ["poland"; "portugal"];
	Hashtbl.add c 'q' [];
	Hashtbl.add c 'r' ["romania"; "russia"];
	Hashtbl.add c 's'
		["san marino"; "serbia"; "slovakia"; "slovenia";
		"spain"; "sweden"; "switzerland"];
	Hashtbl.add c 't' [];
	Hashtbl.add c 'u' ["ukraine"; "united kingdom"];
	Hashtbl.add c 'v' ["vatican city"];
	Hashtbl.add c 'w' [];
	Hashtbl.add c 'x' [];
	Hashtbl.add c 'y' [];
	Hashtbl.add c 'z' [];
	c;;

let rec path' country countries_table solution =
	let rec find_longest_chain countries_table solution list psolution_length psolution =
		match list with
			| [] -> psolution
			| h :: tl ->
				let next_solution = path' h
					(remove_country (Hashtbl.copy countries_table) h)
					(List.rev (h :: List.rev solution))
				in
					if (List.length next_solution) > psolution_length then
						find_longest_chain countries_table solution tl (List.length next_solution) next_solution
					else
						find_longest_chain countries_table solution tl psolution_length psolution
	in
		match (Hashtbl.find countries_table (last_of_str country)) with
		| [] -> solution
		| list -> find_longest_chain countries_table solution list 0 []

let path country = path' country (remove_country (countries) country) [country];;
