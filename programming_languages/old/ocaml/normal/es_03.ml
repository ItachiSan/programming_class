(* For Printf.printf *)
open Printf;;
open List;;

(* Insert code here... *)

(* Our matrix. *)
type matrix = int list list;;

(*
A function to build generic matrices, given sizes and input argument.
"f", passed as parameter, is the function that returns the needed element.
"f" gets all the data, just to be sure of the result.
*)

let matrix_builder n m f =
	(* Helper function to build a row *)
	let rec make_row m f x y =
		if x < m then
			(f n m x y) :: make_row m f (x+1) y 
		else
			[]
	in
	(* Helper function that builds all the rows *)
	let rec loop n m f y =
		if y < n then
			(make_row m f 0 y) :: (loop n m f (y+1))
		else
			[]
	in
		loop n m f 0
;;

(* A function that creates a table with only zeroes. *)
let zeroes n m = matrix_builder n m (fun n m x y -> 0);;

(* A function that builds the identity matrix of size n. *)
let identity n = matrix_builder n n (fun n m x y -> if x==y then 1 else 0);;

(* A function that builds a square matrix of size n with the initial nxn numbers. *)
let init n = matrix_builder n n (fun n m x y -> (y*m) + x + 1);;

(* A function that transposes a matrix *)
let rec transpose matrix =
	(* Using "List" module functions (aliases) *)
	let head = List.hd in
	let tail = List.tl in
	let rec map = List.map in
	match matrix with
	| [] :: _ -> []
	| matrix -> (map head matrix) :: transpose (map tail matrix)
;;

(* A function that multiplies two matrices *)
let ( * ) mA mB =
	(* Using "List" module functions (aliases) *)
	let rec map = List.map in
	let rec map2 = List.map2 in
	let rec foldl = List.fold_left in
	(* Make a single element *)
	let make_element lA lB = foldl ( + ) 0 (map2 ( * ) lA lB) in
	(* The main moltiplication *)
	let rec multiply mA mB =
		match mA with
		| [] -> []
		(*
		The first part creates automagically the first array of elements.
		Then, recursively, creates the others.
		*)
		| h :: t -> (map (make_element h) mB) :: (multiply t mB)
	in
		multiply mA (transpose mB) 
;;

(*
Our "main".
*)
let () =
	Printf.printf "%s\n" "Hello world!"
;;
