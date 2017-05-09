open Goldbach

let main() =
	let rst = goldbach_list 3 2000
	in
	List.iter (fun x ->
		Printf.printf "%d = %d + %d\n" (fst x) (fst (snd x)) (snd (snd x))
	) rst ;;

main() ;;
