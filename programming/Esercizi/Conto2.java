import java.math.BigInteger;

public class Conto2 {

    public static void main(String args[]){
    
    // Dati
    int dato;
    try {
        dato = Integer.parseInt(args[0]);
        }
    catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Devi passare un dato intero da CLI");
        return;
    }
    
    // Lavoro
    // WARNING -> BRACE YOURSELVES, PORCATE AHEAD
    
    // BigInteger k = new BigInteger("0");
    // BigInteger t = new BigInteger("0");
    long k=0;
    for (int i=0; i < dato; i++)
        for (int j=0; j < i; j++)
            {
            //t = new BigInteger(j+""); // Sì, ti inizializzo così perchè sei brutto, ok??
            //k = k.add(t);
            k+=j;
            }
            
    // Fineeee
    System.out.println("Risultato: " + k);
    }

}
