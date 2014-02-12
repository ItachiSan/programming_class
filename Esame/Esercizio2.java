import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

class Esercizio2 {
	public static void main(String args[]){
	// Classi utili
	ArrayList<Aula> A = new ArrayList<Aula>();
	Scanner in = new Scanner(System.in);
	String comando;
	
	while(in.hasNextLine()) // Abbiamo materiale!
		{
		comando = in.nextLine(); // Comando da valutare
		if(comando.charAt(0) == 'P')
			{ // Prenotazione
			StringTokenizer evento = new StringTokenizer(comando,",");
			evento.nextToken(); // Saltiamo la P
			
			String aula; // Dati per l'evento che prendiamo da evento
			int giorno, ora, durata; 
			
			aula = evento.nextToken(); // Nome dell'aula N.B.
			giorno = Integer.parseInt(evento.nextToken());
			ora = Integer.parseInt(evento.nextToken());
			durata = Integer.parseInt(evento.nextToken());
			
			// Verifichiamo se dobbiamo aggiungere l'aula
			if (trovaAula(aula,A) == null)
				A.add(new Aula(aula));
			// Aggiungiamo l'evento
			trovaAula(aula,A).prenota(new Evento(giorno,ora,durata));
			}
			
		else if(comando.charAt(0) == 'F')
			{ // Stampa
			StringTokenizer ricerca = new StringTokenizer(comando,",");
			ricerca.nextToken(); // Saltiamo la F
			// Dati da valutare
			int giorno, ora, durata; 
			giorno = Integer.parseInt(ricerca.nextToken());
			ora = Integer.parseInt(ricerca.nextToken());
			durata = Integer.parseInt(ricerca.nextToken());
			
			System.out.println("Ricerca per il giorno " + giorno + " dalle " + ora + " alle " + (ora + durata) );		
			for (Aula a : A)
				a.printFree(giorno,ora,durata); // Stampa se e solo se l'aula e' disponibile -> vedi Aula.java 
			}
		else
			{ // Comando non valido
			System.out.println("Comando non valido");
			return;
			}
		}
	
	}
	
	private static Aula trovaAula(String s, ArrayList<Aula> A){
		// Ritorniamo il riferimento a un'aula con nome 's'
		// se esiste, altrimenti 'null'
		// Metodo privato in quanto serve solo in questo esercizio
		for (Aula a : A)
			if(a.getNome().equals(s))
				return a;
		return null;
	}
}
