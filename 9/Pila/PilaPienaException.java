package Pila;
class PilaPienaException extends RuntimeException {
    // Costruttori
    public PilaPienaException(String s, Character c){
        super(s + c);
    }
    
    public PilaPienaException(Character c){
        super("Errore nell'inserire nella pila il carattere " + c);
    }
}
