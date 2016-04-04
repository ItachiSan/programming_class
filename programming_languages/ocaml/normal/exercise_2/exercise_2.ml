(* For Printf.printf *)
open Printf;;

(* Let's measure temperatures! *)
type temperature_scale = Celsius
	| Kelvin
	| Fahrenheit
	| Rankine
	| Delisle
	| Newton
	| Reaumur (* Réaumur *)
	| Romer (* Rømer *)
;;

type temperature = float * temperature_scale;;

(* A function from convert to Kelvin, as it is the standard system *)
let convert_from_kelvin (t,_) s =
	match s with
	| Celsius		-> (t -. 273.15,								s)
	| Kelvin		-> (t,											s)
	| Fahrenheit 	-> ((t *. (9.0 /. 5.0)) -. 459.67,				s)
	| Rankine		-> ((t *. (9.0 /. 5.0)),						s)
	| Delisle		-> ((373.15 -. t) *. (3.0 /. 2.0),				s)
	| Newton		-> ((t -. 273.15) *. (33.0 /. 100.0),			s)
	| Reaumur		-> ((t -. 273.15) *. (4.0 /. 5.0),				s)
	| Romer			-> (((t -. 273.15) *. (21.0 /. 40.0)) +. 7.5,	s)
;;

(* A function to convert to Kelvin, as it is the standard system *)
let convert_to_kelvin (t,s) =
	match s with
	| Celsius		-> (t +. 273.15,								Kelvin)
	| Kelvin		-> (t,											Kelvin)
	| Fahrenheit 	-> ((t +. 459.67) *. (5.0 /. 9.0),				Kelvin)
	| Rankine		-> ((t *. (5.0 /. 9.0)),						Kelvin)
	| Delisle		-> ((373.15 -. t) *. (2.0 /. 3.0),				Kelvin)
	| Newton		-> ((t *. (100.0 /. 33.0)) +. 273.15,			Kelvin)
	| Reaumur		-> ((t *. (5.0 /. 4.0)) -. 273.15,				Kelvin)
	| Romer			-> (((t -. 7.5) *. (40.0 /. 21.0)) -. 273.15,	Kelvin)
;;

(* Print a temperature *)
let print_temperature (t,s) =
	let get_scale_string s =
		match s with
		| Celsius		-> "Celsius"
		| Kelvin		-> "Kelvin"
		| Fahrenheit 	-> "Fahrenheit"
		| Rankine		-> "Rankine"
		| Delisle		-> "Delisle"
		| Newton		-> "Newton"
		| Reaumur		-> "Réaumur"
		| Romer			-> "Rømer"
	in
		Printf.printf "%.2f %s degrees\n" t (get_scale_string s) 
;;

(* Convert the temperature in the other scales *)
let convert_temperature (t,s) =
	let scale_list = [
		Celsius;
		Kelvin;
		Fahrenheit;
		Rankine;
		Delisle;
		Newton;
		Reaumur;
		Romer;
	]
	in
	let rec convert_temperature' (t,s) l =
		match l with
		| x :: lt when x == s	-> convert_temperature' (t,s) lt
		| x :: lt when x != s	-> 
			print_temperature (
				convert_from_kelvin (convert_to_kelvin (t,s)) x
			); convert_temperature' (t,s) lt
		| [] 					-> () 
	in
		convert_temperature' (t,s) scale_list
;;

(*
Our "main".
*)
let () =
	print_endline "0 Celsius are";
	convert_temperature (0.0, Celsius);
	print_endline "0 Kelvin are";
	convert_temperature (0.0, Kelvin)
;;
