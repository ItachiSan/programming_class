let cqsort (>:) l = 
	let rec cqsort' list f =
		match list with
			| [] -> f [] 
			| h :: tl ->
				cqsort' (List.filter (fun x -> x >: h) tl) (fun left -> f (
					cqsort' (List.filter (fun x -> h >: x) tl) (fun right ->
						(left @ [h] @ right)
					)
				))
	in cqsort' l (fun x -> x)
