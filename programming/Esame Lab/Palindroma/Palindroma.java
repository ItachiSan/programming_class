import java.util.Scanner;

class Palindroma {
	public static void main(String args[]){
	Scanner in = new Scanner(System.in);
	System.out.print("Riga da valutare: ");
	String s = in.nextLine(); // Stringa in input
	String to_test = ""; // Stringa valutata
	// Creo la stringa da valutare...
	for (int i = 0; i < s.length(); i++)
		if(s.charAt(i) != ' ')
			to_test += s.toLowerCase().charAt(i);
	// E verifico che sia palindroma
	boolean pal = true;
	for (int i=0, j=to_test.length()-1; pal && i < j; i++, j--)
		if (to_test.charAt(i) != to_test.charAt(j))
			pal = false;
	
	if (pal)
		System.out.println("true");
	else
		System.out.println("false");
	}

}