import java.util.*;

public class MatriciFrastagliate {

    public static void main (String args[])
    {
    // Dichiarazione dati
    Scanner in = new Scanner(System.in);
    int m, n=0;
    
    // Numero di righe da CLI
    m = Integer.parseInt(args[0]);
    
    // Creazione tabella con righe fissate
    int[][] tabella = new int[m][];
    
    // Ora mettiamo le colonne    
    for (int i=0; i < m; i++)
        {
        System.out.printf("Inserisci il numero di colonne per la riga %d: ", i+1);
        n=Integer.parseInt(in.nextLine());
        tabella[i] = new int[n];
        }
    System.out.println();
    
    for (int i=0; i < m; i++)
        {
        for (int j=0; j < tabella[i].length; j++)
            {
            tabella[i][j] = (i+1)+(j+1);
            }
        }  
    
    // Stampa informazioni sulla tabella
    for (int i=0; i < m; i++)
        System.out.println("La riga " + (i+1) + " ha " + tabella[i].length + " colonne");
    System.out.println();
    
    // Stampa la vera tabella
        // Stampa tabella
    for (int i=0; i < m; i++)
        {
        for (int j=0; j < tabella[i].length; j++)
            {
            System.out.printf("%2d ", tabella[i][j]);
            }
        System.out.println();
        }
            
    }

}
