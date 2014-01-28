import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.NoSuchElementException;

class Esercizio1 {
	public static void main(String args[]){
	// Roba utile
	Scanner in = new Scanner(System.in);
	Volo V = new Volo("az123",10);
	StringTokenizer comando;
	
	while (in.hasNextLine()){
	// Riceviamo il comando
	try{
	comando = new StringTokenizer(in.nextLine(),",");
	} catch (NoSuchElementException e) {
		System.out.println("Errore");
		break;
	}
	String op = comando.nextToken();
	String nome = comando.nextToken();
	// Controllo lunghezza comando
	if (op.length() != 1)
		{
		System.out.println("Errore nel comando");
		break;
		}
	// Operiamo
	switch(op.toLowerCase().charAt(0)){
		case 'p': 	V.addPrenotazione(new Passeggero(nome));
				break;
		case 's':	V.addPrenotazione(new PasseggeroStar(nome,10));
				break;
		case 'q':	stampaPasseggero( V.cerca(nome), nome, V);
				break;
		default:	System.out.println("Comando non valido");
		}
	}
	
	}
	
	private static void stampaPasseggero(Passeggero p, String n, Volo v){
		if (p == null)
			System.out.println("Il passeggero " + n + " non e' presente sul volo " + v.toString() );
		else
			System.out.println("Il passeggero " + p.toString() + " e' presente sul volo " + v.toString() );
	}
	
}
