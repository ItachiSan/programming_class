// Identico a OrdinaTesto in lezione 5...
// Ma su file! :D

import java.util.*;
import java.io.*;

public class OrdinaParole {

    public static void main (String args[]) throws IOException
    {
    // Dichiarazione dati
    FileReader file = new FileReader(args[0]);
    Scanner in = new Scanner(file);
    ArrayList<String> testo = new ArrayList<String>();
    
    // Aggiunge il testo all'ArrayList
    while (in.hasNext())
        testo.add(in.next());
    
    
    // Il testo non e' ordinato!
    System.out.println("Il testo non ordinato e': " + testo.toString());    
    // Riordino il testo...
    Collections.sort(testo);
    // E lo stampo
    System.out.println("Il testo ordinato e': " + testo.toString());
    }

}
