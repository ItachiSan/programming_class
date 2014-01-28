class PasseggeroStar extends Passeggero {
	// Campi
	private int punteggio;
	
	// Costruttori
	PasseggeroStar(String name, int points){
		super(name);
		punteggio = points;
	}
	
	PasseggeroStar(String name){
		this(name,0);
	}
	
	// Metodi
	public String toString() {
		return super.toString() + " (bonus " + punteggio + ")";
	}
	
	public int getPunti(){
		return punteggio;
	}
	
	public void addBonus(int points){
		punteggio += points;
	}
}
