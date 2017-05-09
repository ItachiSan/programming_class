open Path

let main() =
	print_endline("the longest chain starting from italy is [" ^
		(String.concat ", " (path "italy")) ^ "]" );
	print_endline("the longest chain starting from spain is [" ^
		(String.concat ", " (path "spain")) ^ "]" );
	print_endline("the longest chain starting from switzerland is [" ^
		(String.concat ", " (path "switzerland")) ^ "]" );
	print_endline("the longest chain starting from luxembourg is [" ^
		(String.concat ", " (path "luxembourg")) ^ "]" );
	print_endline("the longest chain starting from belarus is [" ^
		(String.concat ", " (path "belarus")) ^ "]" );
	print_endline("the longest chain starting from belgium is [" ^
	(String.concat ", " (path "belgium")) ^ "]" );
	print_endline("the longest chain starting from portugal is [" ^
		(String.concat ", " (path "portugal")) ^ "]" );;
main();;
