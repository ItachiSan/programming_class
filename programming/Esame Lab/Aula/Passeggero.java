class Passeggero {
	// Campi
	private String nome;
	
	// Costruttori
	Passeggero(String name){
		nome = name;
	}
	
	// Metodi
	public String getNome(){
		return nome;
	}
	
	public String toString() {
		return "passeggero " + nome;
	}
}
