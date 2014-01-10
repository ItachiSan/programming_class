// Usiamo il nostro package :3
import Animali.*;
import java.util.*;

class Main {
    public static void main(String args[])
    {
        // Preparo i blocchetti base
        ArrayList<Animal> lista = new ArrayList<Animal>();    
        Scanner in = new Scanner(System.in);
        Animal animal;
        boolean insert = true;
        
        // Inserisco gli animali
        do {
        System.out.print("Inserisci [s] per uno squalo, [c] per un cane, [q] per smettere: ");
        char c = in.nextLine().toLowerCase().charAt(0);
            switch (c)
            {
            case 's': 
                    System.out.println("Aggiungo uno squalo...");
                    animal = new Shark();
                    lista.add(animal);
                    break;
            case 'c':
                    System.out.println("Aggiungo un cane...");
                    animal = new Dog();
                    lista.add(animal);
                    break;
            case 'q':
                    insert = false;
                    break;   
            default: 
                    System.out.println("Scelta non valida!");           
            }
        } while (insert);
        
        // Tutti gli animali fanno ciao...!
        for (int i=0; i < lista.size(); i++)
            System.out.println("L'animale " + (i+1) + " dice: " + lista.get(i).sayHello() );
            
        // I cani nella lista dicono anche il chip code
        for (int i=0, c=0; i < lista.size(); i++)
            {
            if ( lista.get(i) instanceof Dog )
                {
                System.out.println("Il cane " + (c+1) + " dice: " + ( (Dog) lista.get(i)).getChipCode() );
                c += 1;
                }
            }  
            
    }
}

