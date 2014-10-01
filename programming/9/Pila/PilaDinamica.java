package Pila;
import java.util.ArrayList;

class PilaDinamica {
    // Campi
    ArrayList<Character> stack;
    int pos;
    
    // Costruttore
    public PilaDinamica(){
        stack = new ArrayList<Character>();
        pos = 0;
    }
    
    // Metodi
    public void push(Character c){
        stack.add(c);
        pos++;
    }
    
    public Character pop(){
        if ( empty() )
            throw new PilaVuotaException();
        else
            return stack.get(--pos);
    }
    
    public boolean empty(){
        if (pos == 0)
            return true;
        else
            return false;
    }
}
