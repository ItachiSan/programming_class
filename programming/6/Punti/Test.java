import Punti.*;
import java.util.*;

class Test {

    public static void main(String args[]){
    // Scanner per input dati
    Scanner in = new Scanner(System.in);
    double x,y;
    
    // Test 1: distanza tra due punti
    System.out.println("Test 1: distanza tra due punti");
    // Punto 1
    System.out.print("Punto 1: x = ");
    x = Double.parseDouble(in.nextLine());   
    System.out.print("Punto 1: y = ");
    y = Double.parseDouble(in.nextLine());
    Punto2D a = new Punto2D(x,y);
    
    // Punto 2
    System.out.print("Punto 2: x = ");
    x = Double.parseDouble(in.nextLine());   
    System.out.print("Punto 2: y = ");
    y = Double.parseDouble(in.nextLine());
    Punto2D b = new Punto2D(x,y);    
    
    // Distanza
    System.out.println("La distanza tra i due punti e': " + Punto2D.distance(a,b));
    System.out.println();
    
    // --- Fine test 1 ---
    
    // Test 2: lunghezza di una spezzata
    System.out.println("Test 2: lunghezza di una spezzata");
    System.out.println("Quanti punti vuoi inserire? ");
    int n = Integer.parseInt(in.nextLine());
    Punto2D lista[] = new Punto2D[n];    
    double distanza=0;
    
    // Richiesta punti    
    for(int i=0; i < lista.length; i++){
    System.out.print("y = ");
    y = Double.parseDouble(in.nextLine());
    // Creo il punto i-esimo con coordinate(0,0) e imposto x e y al punto i-esimo
    lista[i] = new Punto2D();
    lista[i].setX(x);
    lista[i].setY(y);
    }
    // Calcolo distanza
    for (int i = 0; i < lista.length-1; i++)
        distanza += Punto2D.distance(lista[i],lista[i+1]);
    // Ed ecco la distanza!
    System.out.println("La lunghezza della spezzata e' " + distanza);
    System.out.println();
    
    // --- Fine test 2 ---
    
    
    
    // Test 5: implementazione toString
    System.out.println("Test 5: implementazione toString");
    // Creazione punto
    System.out.print("Punto P: x = ");
    x = Double.parseDouble(in.nextLine());   
    System.out.print("Punto P: y = ");
    y = Double.parseDouble(in.nextLine());
    Punto2D p = new Punto2D(x,y);
    System.out.println("Il punto P ha coordinate " + p.toString());
    // --- Fine test 5
    
    } 
}
