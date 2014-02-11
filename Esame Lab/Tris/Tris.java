import java.util.Scanner;

class Tris {
    
    public static void main(String args[]){
		
		// Richiesta dati
		Scanner in = new Scanner(System.in);
		
		// Creiamo la tabella
		System.out.print("Grandezza tabella: ");
		int n = Integer.parseInt(in.nextLine()); // Ci serve ancora dopo
		char[][] tris = creaTabella(n);
		
		// Giocatore 1
		String s = ""; // Utile per dopo
		System.out.print("Giocatore 1: ");
		String pg1 = in.nextLine();
		char cp1 = pg1.charAt(0);
		System.out.print("Simbolo per " + pg1 + "= " + cp1 + " ? ");
		if ((s = in.nextLine()).length() > 0)
			cp1 = s.charAt(0);
		
		// Giocatore 2
		System.out.print("Giocatore 2: ");
		String pg2 = in.nextLine();
		char cp2 = pg2.charAt(0);
		System.out.print("Simbolo per " + pg2 + "= " + cp2 + " ? ");
		if ((s = in.nextLine()).length() > 0)
			cp2 = s.charAt(0);
		
		// Partita
		boolean vittoria, piena, inserito;
		vittoria = piena = inserito = false;
		System.out.print("Inizia il giocatore 1 o il giocatore 2? (1/2): ");
		int pg = Integer.parseInt(in.nextLine());
		while ( pg < 1 || pg > 2 )
			{
			System.out.print("Input non valido! Riprova (1/2): ");
			pg = Integer.parseInt(in.nextLine());
			}
		pg = (pg-1)%2; // O 0 o 1, molto più comodo
		char cp = ' ';
		int x, y;
		x = y = -1;
		while(!vittoria && !piena){
			s  = (pg == 0 ? pg1 : pg2);
			cp = (pg == 0 ? cp1 : cp2);
			System.out.println("Turno di " + s + " (" + cp + ")");
			while(!inserito)
				{
				while (x < 0 || x >= n)
					{ // X
					System.out.print("X: ")	;
					x = Integer.parseInt(in.nextLine()) - 1;
					}
				while (y < 0 || y >= n)
					{ // Y
					System.out.print("Y: ");
					y = Integer.parseInt(in.nextLine()) - 1;
					}
				// Inserisco
				inserito = set(tris,X(x),Y(y),cp);
				if(!inserito)
					System.out.println("Casella piena!");
				}
			vittoria = vittoria(tris,n,cp); // Controlliamo se c'è un vincitore
			piena = isPiena(tris,n); // Controlliamo se la tabella è piena
			pg = (pg+1)%2; // Cambiamo giocatore
			System.out.println(stampaTabella(tris)); // Stampiamo la tabella
			// Reimpostiamo l'inserimento
			x = y = -1;
			inserito = false;
			}
			
		// Fine partita
		if (piena)
			System.out.println("La tabella è piena (nessun vincitore)");
		else if (vittoria)
			if (pg == 1) // Abbiamo cambiato il giocatore, ricorda!
				System.out.println("Vince " + pg1 + " (simbolo " + cp1 + ")");
			else
				System.out.println("Vince " + pg2 + " (simbolo " + cp2 + ")");
		else
			System.out.println("???");
	}    

    public static char[][] creaTabella(int n){
    /* Crea una tabella del tris con quadrati formattati in questo modo
    
    +---+--..
    |   |
    +---+--..
    |   |
    .   .
    .   .
    
    Significa che dato n cubi si ha
    lunghezza = 4*n + 1 (il carattere finale della riga)
    altezza = 2*n + 1 (riga in basso)
    
    */
    if (n < 1) // Come minimo deve avere grandezza 1
        return null;
    
    int x = 4*n+1;
    int y = 2*n+1;
    char[][] matrix = new char[x][y];
    // Riempimento matrice
    for (int i=0; i < x; i++)
        for (int j = 0; j < y; j++)
		{
            if (i%4 == 0) { // Righe di riempimento
                if (j%2 == 0)
                    matrix[i][j] = '+';
                else
                    matrix[i][j] = '|';
            } else {        // Righe con scelte
                if (j%2 == 0)
                    matrix[i][j] = '-';
                else
                    matrix[i][j] = ' ';
            }
		}
    return matrix;
    }
    
    public static int X(int x){
        // Ritorna la cordinata corretta della matrice
        return (4*x)+2; // +2 per casella centrale
    }
    
    public static int Y(int y){
        // Ritorna la cordinata corretta della matrice
        return (2*y)+1; // +1 per casella centrale
    }
    

    public static boolean vittoria(char[][] matrix, int n, char p){
        // Funzione per controllare se il giocatore con simbolo p
        // ha fatto tris in matrix
        
        boolean win = false;
        
        // Controllo righe
		for (int j = 0; !win && j < n; j++)
			{
			win = true;
			for (int i=0; i < n; i++)
				if (p != matrix[X(i)][Y(j)])
					win = false;
			}
			
		// Controllo colonne
		if (!win) // Se non abbiamo già
		for (int i = 0; !win && i < n; i++)
			{
			win = true;
			for (int j=0; win && j < n; j++)
				if (p != matrix[X(i)][Y(j)])
					win = false;
			}
		// Controllo diagonali
		if (!win)
		{
		win = true;
		for (int i = 0; i < n; i++)
			if (p != matrix[X(i)][Y(i)])
					win = false;
		}
		
		if (!win)
		{
		win = true;
		for (int i = 0; i < n; i++)
			if (p != matrix[X(i)][Y(n-i-1)])
					win = false;
		}
		
		return win;
	}
	
	public static boolean isPiena(char[][] matrix, int n){
        // Funzione per controllare la tabella è piena
		for (int i=0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (matrix[X(i)][Y(j)] == ' ')
					return false;
		return true;
	}
	
	public static boolean set(char[][] matrix, int x, int y, char p){
		// Riempiamo la casella se è vuota e ritorniamo true
		// Altrimenti non facciamo nulla e ritorniamo false
		if (matrix[x][y] != ' ')
			return false;
		// Se siamo qui, inseriamo il carattere
		matrix[x][y] = p;
		return true;
	}
	
	public static String stampaTabella(char[][] matrix){
		String output = "";
		
		for (int j = 0; j < matrix[0].length; j++)
			{
			for (int i=0; i < matrix.length; i++)
                output += matrix[i][j];
			output += "\n";
			}
		
		return output;
    }
}


