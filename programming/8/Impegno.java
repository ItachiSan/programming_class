class Impegno implements Comparable<Impegno> {
    // Campi
    private int giorno, oraInizio, oraFine;
    private String persona;
    
    public Impegno(int g, int inizio, int fine, String nome){
        giorno=g;
        oraInizio=inizio;
        oraFine=fine;
        persona=nome;
    }

    public int getGiorno(){
        return giorno;
    }

    public int getOraInizio(){
        return oraInizio;
    }
    
    public int getOraFine(){
        return oraFine;
    }
    
    public String getNome(){
        return persona;
    }

    public String toString(){
        return  "Impegno con " + getNome() + 
                " del " getGiorno() + " dalle " + 
                getOraInizio() + " alle " getOraFine();
    }

    public boolean equals(Object altro){
        if (altro instanceof Impegno)
            return equals((Impegno) altro);
        else
            return false;
    }
    
    public boolean equals(Impegno task){
    return  this.giorno==task.giorno &&
            this.oraInizio==task.oraInizio &&
            this.oraFine==task.oraFine &&
            this.persona==task.persona;
    }
    
    public int compareTo(Impegno task){
        if (this.oraInizio > task.oraFine)
            return 1
        else if (this.oraFine < task.oraInizio)
            return -1
        else
            return 0;
    }
}
