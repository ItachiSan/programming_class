import java.util.*;

public class Bisestile {
    
    public static void main(String args[]) {
    
    // Per l'input
    Scanner in = new Scanner(System.in);
    // Chiediamo l'anno
    System.out.println("Inserisci l'anno da valutare... o altro a tuo rischio e pericolo.");
    // e salviamolo
    int anno = in.nextInt();
    
    if (anno%4 == 0)
        System.out.println("L'anno e' bisestile");
    else
        System.out.println("L'anno non e' bisestile");
        
    }

}
