import java.util.*;

public class Tabella {

    public static void main (String args[])
    {
    // Dichiarazione dati
    Scanner in = new Scanner(System.in);
    int m, n;
    
    /* Possibile richiesta dati
    
    // Richiesta righe
    System.out.print("Inserisci il numero di righe: ");
    m=in.nextInt();
    System.out.println();
    // Richiesta colonne
    System.out.print("Inserisci il numero di colonne: ")
    n=in.nextInt();
    System.out.println();
    
    */
    
    // ... ma noi i dati li diamo da linea di comando
    m = Integer.parseInt(args[0]);
    n = Integer.parseInt(args[1]);
    
    // Creazione tabella
    int[][] tabella = new int[m][n];
    
    // Riempio la tabella
    for (int i=0; i < m; i++)
        {
        for (int j=0; j < n; j++)
            {
            tabella[i][j] = (i+1)+(j+1);
            }
        }
        
    // Stampa tabella
    for (int i=0; i < m; i++)
        {
        for (int j=0; j < n; j++)
            {
            System.out.printf("%2d ", tabella[i][j]);
            }
        System.out.println();
        }
    }

}
