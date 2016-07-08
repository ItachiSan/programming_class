(* Opening the needed interfaces. *)
open Comparable;;
open IntervalI;;

(* Define Interval in a polymorphic way, as a functor *)
module Interval (C: Comparable) : (IntervalI with type endpoint = C.t) =
	struct
		exception WrongInterval
		type endpoint = C.t
		type interval = Empty | Interval of endpoint * endpoint

		let create a b =
			match C.compare a b with
			| k when k > 0 -> raise WrongInterval
			| _ -> Interval (a, b)

		let is_empty i =
			match i with
			| Empty -> true
			| _ -> false

		let contains i x =
			match i with
			| Empty -> false
			| Interval (a, b) -> C.compare a x <= 0 && C.compare x b <= 0

		let min a b =
			match C.compare a b with
			| k when k > 0 -> b
			| _ -> a

		let max a b =
			match C.compare a b with
			| k when k < 0 -> b
			| _ -> a


		let intersect i1 i2 =
			match i1, i2 with
			| Empty, _ -> Empty
			| _, Empty -> Empty
			| Interval (a, b), Interval(c, d) ->
				try create (max a c) (min b d)
				with WrongInterval -> Empty

		let tostring i = 
			match i with
			| Empty -> "[]"
			| Interval (a, b) -> "[" ^ C.tostring a ^ "," ^ C.tostring b ^ "]"
	end;;

(* Define Comparable for int and string *)
module IntComparable =
	struct
		type t = int
		let compare a b = a - b
		let tostring i = string_of_int i
	end;;

module StringComparable =
	struct
		type t = string
		let compare a b = String.compare a b
		let tostring s = s
	end;;

(* Finally, define the int and string intervals *)
module IntInterval = Interval(IntComparable)
module StringInterval = Interval(StringComparable)
