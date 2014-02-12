class Evento implements Comparable<Evento>{
	// Campi
	private int giorno, ora, durata;
	
	// Costruttori
	Evento(int day, int hour, int length){
		giorno = day;
		ora = hour;
		durata = length;
	}
	
	Evento(int day, int hour){
		this(day,hour,1);
	}
	
	// Metodi
	public int getGiorno()	{return giorno;}
	public int getOra()	{return ora;}
	public int getDurata()	{return durata;}
	
	public boolean equals(Object o){
		if (o instanceof Evento)
			{
			Evento e = (Evento) o;
			if (giorno == e.giorno && ora == e.ora)
				return true;
			// Imposto i range di ora corretti	
			int start, end, middle;
			if (ora < e.ora)
				{
				start = ora;
				end = ora + durata;
				middle = e.ora;
				}
			else
				{
				start = e.ora;
				end = e.ora + e.durata;
				middle = ora;
				}
			// Controllo	
			return 	giorno == e.giorno &&
				start < middle &&
				middle < end;
			}
		else
			return false;
	}
	
	public int compareTo(Evento e){ // Utile per riordinare gli eventi nell'esercizio 1
		if(giorno == e.giorno){
			if(ora == e.ora)
				return durata - e.durata;
			else
				return ora - e.ora;
		} else
			return giorno - e.giorno;
	}
	
	public String toString(){
		return "Giorno " + giorno + " dalle " + ora + " alle " + (ora + durata);
	}
}
