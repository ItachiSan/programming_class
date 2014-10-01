import java.util.*;

public class OffDiag {

    public static void main (String args[])
    {
    // Dichiarazione dati
    Scanner in = new Scanner(System.in);
    int m;
    
    // Grandezza matrice quadrata da CLI
    m = Integer.parseInt(args[0]);
    
    // Creazione tabella
    int[][] tabella = new int[m][m];
    
    // Riempio la tabella
    for (int i=0; i < m; i++)
        {
        for (int j=0; j < m; j++)
            {
            tabella[i][j] = (i+1)+(j+1);
            }
        }
        
    // Stampa tabella
    for (int i=0; i < m; i++)
        {
        for (int j=0; j < m; j++)
            {
            if (i==j)
                System.out.print("  ");
            else
                System.out.printf("%2d ", tabella[i][j]);
            }
        System.out.println();
        }
    }

}
