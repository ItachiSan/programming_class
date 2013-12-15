import java.util.*;

public class SpezzaParola {

    public static void main (String args[]) {
    
    // Per l'input
    Scanner in = new Scanner(System.in);
    // Chiediamo il cognome...
    System.out.println("Inserisci la parola: ");
    // e salviamolo
    String parola = in.nextLine().toUpperCase(); // toUpperCase per standardizzare l'output
    
    // Dobbiamo stampare fino alla meta' della parola se la lunghezza e' pari, senno' il carattere in piu'
    // lo diamo alla prima sottostringa
    int dividi = parola.length()/2 + parola.length()%2;
    
    // E ora si stampa
    System.out.println(parola.substring(0,dividi));
    System.out.println(parola.substring(dividi));
      
    } 

}
