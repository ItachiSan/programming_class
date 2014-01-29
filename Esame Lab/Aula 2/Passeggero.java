public class Passeggero {
	public String nominativo;
	
	public Passeggero(String n){
		nominativo=n;
	}
	
	public String getPasseggero(){
		return nominativo;
	}
	
	public String toString(){
		return "Passeggero: "+nominativo;
	}
}
