import java.util.*;

public class ArrayString {

    public static void main (String args[])
    {
    // Creiamo un array di stringhe, yeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeah
    ArrayList<String> stringhe = new ArrayList<String>();
    // Ricezione input
    Scanner in = new Scanner(System.in);
    // Altri dati
    int c;
    String s;
    
    // Prima volta
    System.out.println("Inserisci una stringa (input vuoto per terminare):");
    s=in.nextLine();
    
    // Dato che famo i fighi usiamo il for
    for(c=0; !s.equals(""); c++)
        {
        stringhe.add(s);
        // Chiediamo la prossima stringa
        System.out.println("Inserisci una stringa (input vuoto per terminare):");
        s=in.nextLine();
        }
    
    // Stampiamo il risultato
    System.out.println("Hai inserito " + c + " stringhe");
    System.out.println(stringhe.toString());
    
    }

}
