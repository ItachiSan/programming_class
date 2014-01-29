import java.util.ArrayList;

class Volo {
	// Campi
	private String volo;
	private int bonus;
	private ArrayList<Passeggero> clienti;
	
	
	// Costruttori
	Volo(String codice, int points){
		volo = codice;
		bonus = points;
		clienti = new ArrayList<Passeggero>();
	}
	
	Volo(String codice){
		this(codice,0);
	}
	
	// Metodi
	public void addPrenotazione(Passeggero p){
		if (clienti.indexOf(p) == -1)
			if (p instanceof PasseggeroStar)
				{
				clienti.add((PasseggeroStar) p);
				// ((PasseggeroStar) (clienti.get(clienti.indexOf(p)))).addBonus(bonus);
				}
			else // Cliente standard
				clienti.add(p);
	}
	
	public Passeggero cerca(String s){
		for (int i=0; i < clienti.size(); i++)
			if(clienti.get(i).getNome().equals(s))
				return clienti.get(i);
		return null;
	}
	
	public String toString(){
		return volo + " ( bonus " + bonus + " )";
	}
	
}
