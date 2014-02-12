import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

class Esercizio1 {
	public static void main(String args[]){
	
	// Classi utili
	ArrayList<Evento> E = new ArrayList<Evento>();
	Scanner in = new Scanner(System.in);
	String comando;
	
	while(in.hasNextLine()) // Abbiamo comandi da eseguire!
		{
		comando = in.nextLine(); // Prendo il comando e lo valuto
		if(comando.charAt(0) == 'P')
			
			{ // Evento
			
			StringTokenizer evento = new StringTokenizer(comando,",");
			evento.nextToken(); // Saltiamo la P
			
			int giorno, ora, durata; // Dati per l'evento che prendiamo da evento
			giorno = Integer.parseInt(evento.nextToken());
			ora = Integer.parseInt(evento.nextToken());
			durata = Integer.parseInt(evento.nextToken());
			
			// Verifichiamo se dobbiamo aggiungerlo
			Evento a = new Evento(giorno,ora,durata);
			
			boolean aggiungi = true;
			
			for (Evento b : E)
				if (a.equals(b))
					aggiungi=false;
			
			if(aggiungi)
				E.add(a);
			}
			
		else if(comando.charAt(0) == 'S')
		
			{ // Stampa
			Collections.sort(E); // Riordiniamo
			for (Evento pippo : E)
				System.out.println(pippo);
			}
		
		else
			{ // Comando invalido
			System.out.println("Comando non valido");
			return;
			}
		}
	
	}
}
