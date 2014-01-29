import java.util.Scanner;
public class Esercizio1 {

	/**
	 * @param args
	 */
	
	private static void stampaPasseggero(Passeggero p, String n, Volo v){
        if (p == null)
                System.out.println("Il passeggero " + n + " non e' presente sul volo " + v.toString() );
        else
                System.out.println("Il passeggero " + p.toString() + " e' presente sul volo " + v.toString() );
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Volo V = new Volo("az123", 10);
		char comando;
		String nome;
		
		System.out.println("Inserimento: ");
		System.out.print("> ");
		String s=in.nextLine();
		
		while(s.length()>0){
			comando=s.charAt(0);
			System.out.print(comando+"\n");
			nome=s.substring(2);
			System.out.print(nome+"\n");
			
			switch(comando){
				case 'p':
					V.addPrenotazione(new Passeggero(nome));
					break;
				
				case 's':
					V.addPrenotazione(new PasseggeroStar(nome, 10));
					break;
					
				case 'q':
					stampaPasseggero(V.cerca(nome), nome, V);
					break;
					
					default:
						System.out.println("Inserimento errato!");
				
			}
			System.out.print("> ");
			s=in.nextLine();
		}
	}

}
