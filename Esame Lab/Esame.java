abstract class Esame implements Comparable<Esame> {
    // Campi
    private String corso;
    private int matricola;
    
    // Costruttore
    public Esame(String lessons, int user){
        corso=lessons;
        matricola=user;
    }
    
    // Metodi
    abstract boolean isPassato();
    
    public String getCorso(){
        return corso;
    }

    public int getMatricola(){
        return matricola;
    }
    
    public int compareTo(Esame e){
        if (corso.equals(e.corso))
            return matricola - e.matricola;
        else
            return corso.compareTo(e.corso);
    }
}
