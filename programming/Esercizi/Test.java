import java.util.Scanner;
import java.util.ArrayList;

class Test {

    public static void main(String args[]){
    
    Scanner in = new Scanner(System.in);
    ArrayList<String> testo = new ArrayList<String>();
    String l = "";
    
    System.out.print("> ");
    while ( ! ( l = in.nextLine() ).equals("") )
        {
        System.out.print("> ");
        testo.add(l);
        }
    
    for (String s : testo)
        System.out.println("-> " + s);
    
    }

}
