class EsameApprovato extends Esame {
    // Campi
    private boolean approvato;
    
    // Costruttori    
    public EsameApprovato(String lessons, int user,boolean mark){
        super(lessons,user);
        approvato=mark;
    }
    
    // Metodi
    public boolean isPassato(){
        return approvato;
    }
    
    private String isApprovato(){
        if (approvato)
            return "approvato";
        else
            return "";
    }
    
    public String toString(){
        return getCorso() + ", " + getMatricola() + ", " + isApprovato();
    }
} 
