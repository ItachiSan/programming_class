import java.util.*;

public class ArrayToList {

    public static void main (String args[])
    {
    // Dichiarazione dati
    Scanner in = new Scanner(System.in);
    int m, n;
    
    // Dati da CLI
    m = Integer.parseInt(args[0]);
    n = Integer.parseInt(args[1]);
    
    // Creazione tabella
    Integer[][] tabella = new Integer[m][n];
    // ... e della tabella 2
    ArrayList<Integer> tabella2 = new ArrayList<Integer>();
    
    // Riempio la tabella
    for (int i=0; i < m; i++)
        {
        for (int j=0; j < n; j++)
            {
            tabella[i][j] = (i+1)+(j+1);
            }
        }
        
    for (int i=0; i < m; i++)
        Collections.addAll(tabella2, tabella[i]);
        
    // Stampa la tabella, the new way!
    System.out.println(tabella2.toString());
    }

}


