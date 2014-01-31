import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.ArrayList;

class Esercizio2 {
	public static void main(String args[]){
	
	// Roba utile
	Scanner in = new Scanner(System.in);
	ArrayList<Volo> V = new ArrayList<Volo>();
	ArrayList<PasseggeroStar> P = new ArrayList<PasseggeroStar>();
	StringTokenizer comando;
	int voli = -1;
	int bonus = 0;
	
	// Programma
	while (in.hasNextLine()){
	
	// Riceviamo il comando
	try{
	comando = new StringTokenizer(in.nextLine(),",");
	} catch (NoSuchElementException e) {
		System.out.println("Errore");
		comando = null;
	}
	
	// Impostiamo
	String op, nome;
	try { 
	    op = comando.nextToken();
	    nome = comando.nextToken();
	} catch (NoSuchElementException f) {
	    System.out.println("Errore nella formattazione");
		op = nome = ""; // Evitiamo rotture nella compilazione
	}	
	
	// Controllo lunghezza comando
	if (comando == null && op.length() != 1)
		{
		System.out.println("Errore nel comando");
		break;
		}
		
	// Operiamo
	if (! op.equals("") )
	switch(op.toLowerCase().charAt(0)){
		case 'v':	V.add(new Volo(nome, (bonus = Integer.parseInt(comando.nextToken()) ) ) );
				    voli++;
				    break;
		
		case 'p': 	if (voli < 0 ) {System.out.println("Nessun volo"); break;}
				    V.get(voli).addPrenotazione(new Passeggero(nome));
				    break;
		
		case 's':	if (voli < 0 ) {System.out.println("Nessun volo"); break;}
				    PasseggeroStar tizio = cercaS(nome,P);
				    if (tizio == null)
					    tizio = new PasseggeroStar(nome,bonus);
				    V.get(voli).addPrenotazione(tizio);
				    if (P.indexOf(tizio) == -1) 
				    	P.add(tizio);
				    else
				    	((PasseggeroStar) P.get(P.indexOf(tizio))).addBonus(bonus);
				    break;
		
		case 'q':	if (voli < 0 ) {System.out.println("Nessun volo"); break;}
		            for (Volo x : V)
				        stampaPasseggero( x.cerca(nome), nome, x, P);
				    break;
		
		default:	System.out.println("Comando non valido");
		}
	}
	
	}
	
	private static void stampaPasseggero(Passeggero p, String n, Volo v, ArrayList<PasseggeroStar> P){
		if (p == null)
			System.out.println("Il passeggero " + n + " non e' presente sul volo " + v.toString() );
		else if (p instanceof PasseggeroStar){
			PasseggeroStar tizio = P.get(P.indexOf((PasseggeroStar) p));
			System.out.println("Il passeggero " + tizio.toString() + " e' presente sul volo " + v.toString() );
			}
		else
			System.out.println("Il passeggero " + p.toString() + " e' presente sul volo " + v.toString() );
	}
	
	private static PasseggeroStar cercaS(String s, ArrayList<PasseggeroStar> P){
		for (int i=0; i < P.size(); i++)
			if(P.get(i).getNome().equals(s))
				return P.get(i);
		return null;
	}
			
}
