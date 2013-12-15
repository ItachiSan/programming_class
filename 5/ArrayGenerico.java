import java.util.*;
// Per la classe Cerchio
import prog.utili.*;

public class ArrayGenerico {

    public static void main (String args[])
    {
    // Dichiarazione dati
    Scanner in = new Scanner(System.in);
    int n;
    double x;
    char c;
    boolean cerchi;
    Figura[] lista;
    
    // Numero delle figure da CLI
    n = Integer.parseInt(args[0]);
    
    // Chiediamo se cerchi o quadrati
    System.out.println("Vuoi inserire cerchi (c) o quadrati (q)?");
    c = in.nextLine().toUpperCase().charAt(0); // Salvo la stringa, la metto in upper case e tengo da parte il primo carattere
    switch (c)
        {
        case 'C': lista = new Cerchio[n];
                System.out.println("Scelta: Cerchi");
                break;
        case 'Q': lista = new Quadrato[n];
                System.out.println("Scelta: Quadrati");
                break;
        default: System.out.println("Scelta non valida. Chiusura programma.");
                 return;
        }
    
    // Evitiamo rotture dopo
    if (c=='C')
        cerchi = true;
    else
        cerchi = false;
        
    // Prepariamo l'utente
    if (cerchi)
        System.out.println("Inserire i raggi dei cerchi:");
    else
        System.out.println("Inserire i lati dei quadrati:");
        
    // Creiamo i cerchi/quadrati
    for (int i=0; i < n; i++)
        {
        if (cerchi)
            System.out.printf("Cerchio %d: ", (i+1) );
        else
            System.out.printf("Quadrato %d: ", (i+1) );
        
        x = Double.parseDouble(in.nextLine());
        
        if (cerchi)
            lista[i] = new Cerchio(x);
        else
            lista[i] = new Quadrato(x);
        }
    System.out.println();
        
    // Stampa area dei cerchi/quadrati
    if (cerchi)
        System.out.println("Le aree dei cerchi sono:");
    else
        System.out.println("Le aree dei quadrati sono sono:");
        
    for (int i=0; i < n; i++) {
        if (cerchi)
            System.out.printf("Cerchio %d: %.2f \n", (i+1), lista[i].getArea());
        else
            System.out.printf("Quadrato %d: %.2f \n", (i+1), lista[i].getArea());
        }
    }

}
