import java.util.*;
import java.io.*;

public class CopiaFile {

    public static void main (String args[]) throws IOException
    {
    // Dichiarazione dati
    FileReader file = new FileReader(args[0]);
    FileWriter out_file = new FileWriter(args[1]);
    PrintWriter pwr = new PrintWriter(out_file); 
    
    // Stampo riga per riga nel file copia
    while (in.hasNext())
        pwr.println(in.nextLine());
    
    // Chiudo file e printer
    pwr.flush();
    out_file.close();
    
    System.out.println("Copiato!");    
    }

}
