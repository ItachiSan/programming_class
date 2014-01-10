package Pila;
class PilaStatica {
    // Campi
    Character[] stack;
    int pos;
    
    // Costruttore
    public PilaStatica(){
        stack = new Character[10];
        pos = 0;
    }
    
    // Metodi
    public void push(Character c){
        if (pos >= stack.length)
            throw new PilaPienaException("Errore inserendo il carattere ", c);
        else
            {
            stack[pos] = c;
            pos++;
            }
    }
    
    public Character pop(){
        if ( empty() )
            throw new PilaVuotaException();
        else
            return stack[--pos];
    }
    
    public boolean empty(){
        if (pos == 0)
            return true;
        else
            return false;
    }
}
