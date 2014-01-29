import java.util.ArrayList;

public class Volo {
	String codice;
	int bonus;
	ArrayList<Passeggero> prenotazioni;
	
	public Volo(String c, int b){
		codice=c;
		bonus=b;
		prenotazioni = new ArrayList<Passeggero>();
	}
	public Volo(String c){
		codice=c;
		bonus=0;
	}
	
	public void addPrenotazione(Passeggero p){
	    boolean assente = true;
	    
		for(int i = 0; assente && i < prenotazioni.size(); i++)
	        if(prenotazioni.get(i).getPasseggero().equals(p.getPasseggero()))) // Sono stupido io, confronto tra stringhe
		        assente = false;

		if(assente)
		    {        
		    prenotazioni.add(p);
		    int i = prenotazioni.indexOf(p); // Ritroviamo il passeggero (Teoricamente è l'ultimo, ma non si sa mai)
		    if(prenotazioni.get(i) instanceof PasseggeroStar)
		        ((PasseggeroStar) prenotazioni.get(i)).aggiornaBonus(bonus);
		    }
		}
	}
	
	public Passeggero cerca(String s){
        for(int i = 0; assente && i < prenotazioni.size(); i++)
	        if(prenotazioni.get(i).getPasseggero().equals(s)))
	            return prenotazioni.get(i); // Trovato!
	    return null;
	    }
	
	public String toString(){
		return codice + " (bonus "+ bonus +" ) ";
	}
	
}
