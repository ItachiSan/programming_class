public class PasseggeroStar extends Passeggero{
	String nominativo;
	int bonus;
	
	public PasseggeroStar(String n){
		super(n);
		bonus=0;
	}
	
	public PasseggeroStar(String n, int b){
		super(n);
		bonus=b;
	}
	
	public void aggiornaBonus(int b){
		bonus+=b;
	}
	
	public String getPasseggero(){
		return nominativo;
	}
	
	public int getBonus(){
		return bonus;
	}
	
	public String toString(){
		return super.toString() + " (bonus "+bonus;
	}
}
