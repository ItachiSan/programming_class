import java.util.*;

public class Trasposta {

    public static void main (String args[])
    {
    // Dichiarazione dati
    int m, n;
        
    // Richiesta dati da CLI
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
    for (int i=0; i < n; i++)
        {
        for (int j=0; j < m; j++)
            {
            System.out.print(tabella[j][i] + " ");
            }
        System.out.println();
        }
    }

}
