import java.util.ArrayList;

class Carrello {
    // Campi
    private ArrayList<Acquisto> lista;
    
    // Costruttori
    public Carrello(){
        lista = new ArrayList<Acquisto>(); 
    }

    // Metodi
    public void metti(Acquisto acq){
        lista.add(acq);
    }

    public void togli(Acquisto acq){
        lista.remove(acq);
    }
    
    public int totaleCat(int c){
        int prezzo=0;
        
        for(int i=0; i < lista.size(); i++)
            if (lista.get(i).getCategoria() == c)
                prezzo += lista.get(i).getPrezzo();
                
        return prezzo;
    }
    
    public void togliDup(){
        for(int i=0; i < lista.size(); i++)
            for(int j=0; j < lista.size(); j++)
                if (lista.get(i).equals(lista.get(j)) && i!=j)
                    lista.remove(j--);
    }
    
    // Metodo per test                
    public int size(){
         return lista.size();
    }                

}
