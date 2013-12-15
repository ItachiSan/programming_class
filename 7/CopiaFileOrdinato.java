import java.util.*;
import java.io.*;

public class CopiaFileOrdinato {

    public static void main (String args[]) throws IOException
    {
    // Dichiarazione dati
    FileReader file = new FileReader(args[0]);
    FileWriter out_file = new FileWriter(args[1]);
    PrintWriter pwr = new PrintWriter(out_file);
    Scanner in = new Scanner(file);
    ArrayList<String> testo = new ArrayList<String>();
    
    // Aggiunge il testo all'ArrayList
    while (in.hasNext())
        testo.add(in.next());
    
    // Riordino il testo...
    Collections.sort(testo);
        
    // Stampa il testo dall'ArrayList al file copia
    for (int i=0; i < testo.size(); i++)
        pwr.println(testo.get(i));
    
    // Chiudo file e printer
    pwr.flush();
    out_file.close();
    
    System.out.println("Ordinato e copiato!");    
    }

}
