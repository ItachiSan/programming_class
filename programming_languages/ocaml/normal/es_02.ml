(* For Printf.printf *)
open Printf;;

(* Insert code here... *)

(* Temperature scales datatype. *)
type temperature_scale = Kelvin
	| Celsius
	| Fahrenheit
	| Rankine
	| Delisle
	| Newton
	| Reaumur (* Réaumur *)
	| Romer (* Rømer *)
;;
(* Datatype for a temperature, which has a degree and a scale *)
type temperature = float * temperature_scale;;

(* A list of all the temperatures *)
let temperature_scales = [Kelvin;Celsius;Fahrenheit;Rankine;Delisle;Newton;Reaumur;Romer];;

(* Conversion table from and to Kelvin degrees.
Celsius		[°C] = [K] − 273.15						[K] = [°C] + 273.15
Fahrenheit	[°F] = [K] × 9⁄5 − 459.67				[K] = ([°F] + 459.67) × 5⁄9
Rankine		[°R] = [K] × 9⁄5						[K] = [°R] × 5⁄9
Delisle		[°De] = (373.15 − [K]) × 3⁄2			[K] = 373.15 − [°De] × 2⁄3
Newton		[°N] = ([K] − 273.15) × 33⁄100			[K] = [°N] × 100⁄33 + 273.15
Réaumur		[°Ré] = ([K] − 273.15) × 4⁄5			[K] = [°Ré] × 5⁄4 + 273.15
Rømer		[°Rø] = ([K] − 273.15) × 21⁄40 + 7.5	[K] = ([°Rø] − 7.5) × 40⁄21 + 273.15
*)

(*
A function that converts a Kelvin temperature to any other temperature scale.
*)
let from_Kelvin (d, _) s =
	match s with
	| Kelvin -> d
	| Celsius -> d -. 273.15 
	| Fahrenheit -> (d *. (9. /. 5.)) -. 459.67
	| Rankine -> d *. (9. /. 5.)
	| Delisle -> (373.15 -. d) *. (3. /. 2.)
	| Newton -> (d -. 273.15) *. (33. /. 100.)
	| Reaumur -> (d -. 273.15) *. (4. /. 5.)
	| Romer -> ((d -. 273.15) *. (21. /. 40.)) +. 7.5
;;

(*
A function that converts any temperature to a Kelvin temperature.
*)
let to_Kelvin (d, s) =
	match s with
	| Kelvin -> d
	| Celsius -> d +. 273.15 
	| Fahrenheit -> (d +. 459.67) *. (5. /. 9.)
	| Rankine -> d *. (5. /. 9.)
	| Delisle -> (373.15 -. d) *. (2. /. 3.)
	| Newton -> (d *. (100. /. 33.)) +. 273.15
	| Reaumur -> (d *. (5. /. 4.)) +. 273.15
	| Romer -> ((d -. 7.5) *. (40. /. 21.)) +. 273.15
;;

(* Return a string that relates to the scale *)
let scale_string scale =
	match scale with
	| Kelvin -> "Kelvin"
	| Celsius -> "Celsius" 
	| Fahrenheit -> "Fahrenheit"
	| Rankine -> "Rankine"
	| Delisle -> "Delisle"
	| Newton -> "Newton"
	| Reaumur -> "Réaumur"
	| Romer -> "Rømer"
;;

(*
Print a line for the conversion of a temperature to a specific scale.
The line has the information of the temperature and the scale
*)
let print_conversion temperature scale =
	Printf.printf "%12s\t%.2f\n" (scale_string scale) (from_Kelvin temperature scale)
;;

(* Print a full conversion table for a number in all the scales *)
let print_conversion_table_number number =
	let rec loop t scales =
	match scales with
		| h :: l -> print_conversion t h; loop t l;
		| [] -> ()
	in
		loop (number,Kelvin) temperature_scales
;;

(* Print a full conversion table for a temperature in all the scales *)
let print_conversion_table_temperature ((d,s) as temperature) =
	let rec loop t scales =
	match scales with
		| h :: l when h == s -> loop t l;
		| h :: l -> print_conversion t h; loop t l;
		| [] -> ()
	in
		loop temperature temperature_scales
;;

(*
Our "main".
*)
let () =
	print_string "Normal conversion table\n";
	print_conversion_table_number 1.;
	print_string "Converting 10°C (Celius) to all the temperatures\n";
	print_conversion_table_temperature (10.,Celsius);
;;
