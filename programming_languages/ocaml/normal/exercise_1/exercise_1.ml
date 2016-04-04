(* For Printf.printf *)
open Printf;;

(* Elements lists... *)
let alkaline_earth_metals = [
	("beryllium",4);
	("magnesium",12);
	("calcium",20);
	("strontium",38);
	("barium",56);
	("radium",88);
];;

let noble_gases = [
	("helium",2);
	("neon",10);
	("argon",18);
	("krypton",36);
	("xenon",54);
	("radon",86);
];;

(* Functions for the exercise *)
(* Find the highest element *)
let highest list =
	let rec highest' list (name,num) =
		match list with
		| (s,x) :: lt when num > x 	-> highest' lt (name,num)
		| (s,x) :: lt when num <= x	-> highest' lt (s,x)
		| [] -> (name,num)
	in
		highest' list ("Dummy",0)
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
		| (x,y) :: l when b < y 	-> elem :: (x,y) :: l
		| (x,y) :: l when b >= y 	-> (x,y) :: insert elem l
	in
		match list with
		| [] -> []
		| x :: l -> insert x (sort l)
;;

(*
Print all the elements in the elements list.
*)
let rec print_element_list list =
	let print_element (a,b) = Printf.printf "%3d\t%s\n" b a in
	match list with
		| el :: lt 	-> print_element el; print_element_list lt
		| [] 		-> ()
;;

(*
Our "main".
*)
let () =
	print_element_list(sort (alkaline_earth_metals @ noble_gases))
;;
