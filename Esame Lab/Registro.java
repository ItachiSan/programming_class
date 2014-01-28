import java.util.ArrayList;
import java.util.Collections;

class Registro {
    // Campi
    private String docente;
    private ArrayList<Esame> elenco;

    // Costruttore    
    public Registro(String prof){
        docente = prof;
        elenco = new ArrayList<Esame>();
    }

    // Metodi
    public void aggiungiEsame(Esame e){
        if (elenco.indexOf(e) == -1)
            elenco.add(e);
    }

    public Esame cercaEsame(String nome, int matricola){
        for (int i=0; i < elenco.size(); i++)
            if (elenco.get(i).getCorso().equals(nome) && elenco.get(i).getMatricola() == matricola){
                return elenco.get(i);
        }
        return null;
    }

    public Esame rimuoviEsame(String nome, int matricola){
        for (int i=0; i < elenco.size(); i++)
            if (elenco.get(i).getCorso().equals(nome) && elenco.get(i).getMatricola() == matricola){
                Esame f = elenco.get(i);
                elenco.remove(i);
                return f;
        }
        return null;
    }
    
    public Esame getEsame(int index){
        return elenco.get(index);
    }
    
    public int numeroEsami(){
        return elenco.size();
    }
    
    public String getDocente(){
        return docente;
    }
    
    public void ordina(){
        Collections.sort(elenco);        
    }

    public double frazionePassati(){
        if (elenco.size() == 0)
            return 0d;
        int passati = 0;
        for (int i = 0; i < elenco.size(); i++)
            if (elenco.get(i).isPassato())
                passati++;
        return (double) passati/elenco.size();        
    }
    
    public String toString() {
        String output="";
        for (int i = 0; i < elenco.size(); i++)
            output = output + elenco.get(i).toString() + "\n";
        return output;
    }
}
