import java.util.*;

public class ConfrontoSommaArray {

    public static void riempiArrayInt (int[] array) {
    Scanner in = new Scanner(System.in);
    for (int i=0; i < array.length; i++)
        {
        System.out.print("Valore " + (i+1) + " dell'array: ");
        array[i]= in.nextInt();
        }
    System.out.println();
    }

    public static void main (String args[]) {    
    
    //int[] a = new int[4];
    int[] a = {0,0,0,0};
    int[] b = {0,0,0,0};
    int[] c = {0,0,0,0};
    
    // Richiesta dati
    System.out.println("--- Array A ---");
    riempiArrayInt(a);
    System.out.println("--- Array B ---");
    riempiArrayInt(b);
    System.out.println("--- Array C (A+B)---");
    riempiArrayInt(c);
    
    System.out.println("--- Confronto [ C(i) = A(i)+B(i) ] ---");
    for (int i=0; i < c.length; i++)
        {
        if ( c[i] != (a[i]+b[i]) ) {
            System.out.println("NO");
            return;
            }
        }
    
    System.out.println("SI");
    }
    
}
