import java.util.ArrayList;

class Aula{
	// Campi
	private String nome;
	private ArrayList<Evento> elenco;
	
	// Costruttori
	Aula(String s){
		nome = s;
		elenco = new ArrayList<Evento>();
	}
	
	// Metodi
	public String getNome(){
		return nome;
	}
	
	
	public void prenota(Evento e){
	boolean aggiungi = true; // Assumiamo di aggiungerlo
	
	for(Evento f : elenco)
		if(e.equals(f))
			aggiungi=false; // Evento trovato, non bisogna aggiungere
	
	if(aggiungi) // Possiamo aggiungere...
		elenco.add(e); // E lo facciamo
	}
	
	
	public boolean isFree(int giorno, int oraInizio, int durata){
	Evento e = new Evento(giorno,oraInizio,durata); // Il nostro ipotetico evento	
	
	for(Evento f : elenco)
		if(e.equals(f))
			return false; // Evento trovato, non ho lo spazio
	
	return true; // Lo spazio c'e'
	}
	
	
	public int occupazione(int giorno){
	int ore = 0; // Ore di occupazione
	
	for(Evento e : elenco)
		if(e.getGiorno() == giorno) // Se troviamo l'evento in quel giorno...
			ore += e.getDurata(); // Sommiamo le sue ore a quelle di occupazione
	
	return ore; // A voi!
	}
	
	
	public String toString(){
		String output = "Aula " + nome + "\n";
		for(Evento e : elenco)
			output += e.toString() + "\n";
		return output;
	}
	
	
	public void printFree(int giorno, int oraInizio, int durata){
		if(isFree(giorno,oraInizio,durata))
			System.out.println("Disponibile " + nome + ", occupata per " + occupazione(giorno) + " ore");
	}
		
}
