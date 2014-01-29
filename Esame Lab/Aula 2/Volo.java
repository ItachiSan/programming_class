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
		for(Passeggero x : prenotazioni){
			// if(!(x.getPasseggero().equals(p.getPasseggero()))){ // L'equals è di Object, tornerà sempre false
				prenotazioni.add(p);
				if(p instanceof PasseggeroStar){
					((PasseggeroStar) p).aggiornaBonus(bonus);
				}
			}
		}
	}
	
	public Passeggero cerca(String s){
		Passeggero p=null;
		if((prenotazioni.indexOf(s))>-1){
			// p=new Passeggero(s); <- ritorni un nuovo passeggero, non quello che cerchi
		}
		return p;
		
	}
	
	public String toString(){
		return codice + " (bonus "+ bonus +" ) ";
	}
	
}
