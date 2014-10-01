import java.util.*;

public class Turno {

    public static void main (String args[]) {
    
    // Per l'input
    Scanner in = new Scanner(System.in);
    // Chiediamo il cognome...
    System.out.println("Inserisci il cognome: ");
    // e salviamolo
    String cognome = in.nextLine();
    // Dobbiamo valutare la prima lettra e dire in quale turno e'
    char c = cognome.toUpperCase().charAt(0); // Usiamo il toUpperCase per evitare rotture
    
    if (c < 'M') {
    
        // Siamo nella prima edizione...
        System.out.println("Edizione 1");
        
        // Check del turno
        if (c < 'E') {
            // 1a edizione
            System.out.println("Turno A"); 
            } else {
            // 2a edizione
            System.out.println("Turno B"); 
            }
            
    } else {
    
        // Siamo nella prima edizione...
        System.out.println("Edizione 2");
        
        // Check del turno
        if (c < 'Q') {
            // 1a edizione
            System.out.println("Turno A"); 
            } else {
            // 2a edizione
            System.out.println("Turno B"); 
            }
    }
    
    
    // Ricorsiviamo... in maniera porca
    System.out.println("Inserisci qualcosa per continuare, altrimenti INVIO per chiudere...");
    if (in.nextLine().length() != 0 ) {
        Turno.main(args);   
    }
    
    } 

}
