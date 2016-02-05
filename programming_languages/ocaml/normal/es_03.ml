(* For Printf.printf *)
open Printf;;

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
let init n = matrix_builder n n (fun n m x y -> (y*m)+x+1);;

(*
1. A function zeroes to construct a matrix of size n×m filled with zeros.
2. A function identity to construct the identity matrix (the one with all 0s but the 1s on the
diagonal) of given size.
3. A function init to construct a square matrix of a given size n filled with the first n×n
integers.
4. A function transpose that transposes a generic matrix independently of its size and content.
5. A function * that multiplies two matrices non necessarily square matrices.
*)

(*
Our "main".
*)
let () =
	Printf.printf "%s\n" "Hello world!"
;;
