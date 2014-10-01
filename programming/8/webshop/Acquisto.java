class Acquisto {
    // Campi
    private int costo, categoria;
    private String descrizione;
    // Fine Campi
    
    // Costruttori
    public Acquisto(int x, int y, String z) {
        costo=x;
        categoria=y;
        descrizione=z;    
    }
    // Costruttori secondari <- evitano conflitti, non per altro
    public Acquisto(int x, int y) {
        this(x,y,"Nessuna descrizione");
    }
    
    public Acquisto(int x) {
        this(x,1,"Nessuna descrizione");
    }

    public Acquisto() {
        this(1,1,"Nessuna descrizione");
    }
    // Fine costruttori
    
    // Metodi
    public String getDesc(){
        return descrizione;
    }
    
    public int getPrezzo(){
        return costo;
    }
    
    public int getCategoria(){
        return categoria;
    }
    
    public boolean equals(Object altro){
        if (altro instanceof Acquisto)
            return equals((Acquisto) altro);
        else
            return false;
    }
    
    public boolean equals(Acquisto acquisto){
    return  this.costo==acquisto.costo &&
            this.categoria==acquisto.categoria &&
            this.descrizione==acquisto.descrizione;
    }
    
    public String toString(){
    return "Costo: " + costo + "\nCategoria: " + categoria + "\nDescrizione: " + descrizione;
    }
}
