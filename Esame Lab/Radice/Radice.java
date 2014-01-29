import java.lang.IllegalArgumentException;

class Radice {
    public static void main(String args[]) throws IllegalArgumentException {
    int[] C;
    if (args.length == 0)
        {
        throw new IllegalArgumentException();
        // C = new int[1];
        }
    else
        {
        // Array dei valory
        C = new int[args.length];
        for (int i = 0; i < args.length; i++)
            {
            C[i] = Integer.parseInt(args[i]);
            if (C[i] < 1)
                throw new IllegalArgumentException();
            }
        }    
    
    /* Stampa il polinomio
    String test = "";
    for (int i = 0; i < C.length; i++)
        test = test + C[i] + "x^" + (C.length-i) + " + ";
    System.out.println(test + "(-1)");   
    */
    double sup = 1.0;
    double inf = 0.0;
    boolean trovato = false;
    double media = 0.0, f;
    // double x;
    while (!trovato)
        {
        // Imposto i valori
        // f = x = 0.0; WIP
        f = 0.0;
        media = (sup + inf)/2;
        System.out.println("Approssimo a " + media);
        // Ottengo la funzione nel punto medio
        for (int i = 0; i < C.length; i++)
        // for (int i = 0; i < C.length; i++, x = media) WIP
            {
            /* WIP
            for (int j = 0; j < (C.length-i-1); j++)
                x *= media;
            f += C[i] * x;
            */
            f += C[i] * Math.pow(media, (C.length-i));
            
            }
        f -= 1.0; // Aggiungo il -1
        
        // Scopriamo che fare
        // if (f == 0.0 || Math.abs(f) < 0.0000001 ) <- Va bene anche questa
        if (f == 0.0 || (f < 0.0000001 && f > -0.0000001) )
            trovato = true;
        else if (f > 0)
            sup = media;
        else
            inf = media;
        }
    System.out.println(media);    
    }
}
