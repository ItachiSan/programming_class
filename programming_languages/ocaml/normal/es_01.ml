open Printf;;

(*
A function to print all the elements in a list.
An element is a tuple of a string and an integer.
*)
let print_element (a,b) = Printf.printf "(%3d)\t%s\n" b a;;

(*
A function to print all the elements in a list.
An element is a tuple of a string and an integer.
*)
let rec print_element_list list =
	match list with
	| x :: l -> print_element x; print_element_list l;
	| [] -> ()
;;

(*
Find the biggest element in the list passed as argument.
*)
let find_highest_element list = 
	let rec search list (a,b) =
		match list with
		| (s,x) :: l when x > b -> search l (s,x)
		| (s,x) :: l when x <= b -> search l (a,b)
		| [] -> (a,b)
		| _::_ -> (a,b) (* Prevent useless warnings *)
	in
		search list ("Doh",0) (* Use a dummy element to start the search *)
;;

(*
Insertion sort for elements.
Proudly copy-pasted from:
http://ocaml.org/learn/taste.html
and then adapted
*)
let rec sort list =
	let rec insert ((a,b) as elem) list =
		match list with
		| [] -> [elem]
		| (x,y) :: l ->
			if b < y then elem :: (x,y) :: l
			else (x,y) :: insert elem l
	in
		match list with
		| [] -> []
		| x :: l -> insert x (sort l)
;;

(*
Testing the functions.
*)
let () =
	let alkaline_earth_metals = [
		("beryllium",4);
		("magnesium",12);
		("calcium",20);
		("strontium",38);
		("barium",56);
		("radium",88);
	] in
	let noble_gases = [
		("helium",2);
		("neon",10);
		("argon",18);
		("krypton",36);
		("xenon",54);
		("radon",86);
	] in

	print_string "Alkaline earth metals:\n";
	print_element_list alkaline_earth_metals;
	print_string "Alkaline noble gases:\n";
	print_element_list noble_gases;
	print_string "Highest alkaline earth metal:\n";
	print_element (find_highest_element alkaline_earth_metals);
	print_string "Highest noble gas:\n";
	print_element (find_highest_element noble_gases);
	print_string "Complete list\n";
	print_element_list (alkaline_earth_metals @ noble_gases);
	print_string "Complete ordered list:\n";
	print_element_list (sort (alkaline_earth_metals @ noble_gases))
;;
