import java.util.*;

public class OrdinaTesto {

    public static void main (String args[])
    {
    // Dichiarazione dati
    Scanner in = new Scanner(System.in);
    ArrayList<String> testo = new ArrayList<String>();
    
    // Ricezione testo in input
    System.out.println("Inserisci il testo da ordinare:");
    while (in.hasNext())
        testo.add(in.nextLine());
    System.out.println();
    
    // Riordino il testo...
    Collections.sort(testo);
    // e lo stampo
    System.out.println(testo.toString());
    }

}
