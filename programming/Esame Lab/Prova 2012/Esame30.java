import java.io.IOException;

class Esame30 extends Esame {
    // Campi
    private int voto;
    private boolean lode;
    
    // Costruttori    
    public Esame30(String lessons, int user, int mark, boolean laude) throws IOException {
        super(lessons,user);
        if (mark < 0 || mark > 30 || (laude == true && mark !=30) ) 
            throw new IOException();
        voto=mark;        
        lode=laude;
    }
    
    public Esame30(String lessons, int user, int mark) throws IOException {
        this(lessons,user,mark,false);
    }

    // Metodi
    public boolean isPassato(){
        return voto > 17;
    }
    
    public int getVoto(){
        return voto;
    }
    
    public boolean getLode(){
        return lode;
    }
    
    private String conLode(){
        if (lode)
            return "con lode";
        else
            return "";
    }
    
    public String toString(){
        return getCorso() + ", " + getMatricola() + ", " + voto + " " + conLode();
    }
} 
