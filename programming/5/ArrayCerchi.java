import java.util.*;
// Per la classe Cerchio
import prog.utili.*;

public class ArrayCerchi {

    public static void main (String args[])
    {
    // Dichiarazione dati
    Scanner in = new Scanner(System.in);
    int n;
    double x;

    // Numero dei cerchi da CLI
    n = Integer.parseInt(args[0]);
    
    // Creazione lista
    Cerchio[] lista = new Cerchio[n];
    
    // Prepariamo l'utente
    System.out.println("Inserire i raggi dei cerchi:");
    
    // Creiamo i cerchi
    for (int i=0; i < n; i++)
        {
        System.out.printf("Cerchio %d: ", (i+1) );
        x = Double.parseDouble(in.nextLine());
        lista[i] = new Cerchio(x);
        }
    System.out.println();
        
    // Stampa area dei cerchi
    System.out.println("Le aree dei cerchi sono:");
    for (int i=0; i < n; i++)
        System.out.printf("Cerchio %d: %.2f \n", (i+1), lista[i].getArea());
                
    }

}
