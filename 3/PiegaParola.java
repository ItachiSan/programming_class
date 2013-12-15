import java.util.*;

public class PiegaParola {

    public static void main (String args[]) {
    
    Scanner in = new Scanner(System.in);
    System.out.print("Scrivi la parola da piegare: ");
    String s = in.nextLine();
    
    // Break if we can't work on it
    
    if (s.length()%2==0)
        return;
    
    // Real work
      
    for (int i=0; i < s.length()/2; i++)
        {
        for (int j=0; j < s.length(); j++)
            {
            if (j==i | j==s.length()-i-1)    
                System.out.print(s.charAt(j));
            else
                System.out.print(" ");
            }
        System.out.println();
        }
        
    for (int i=0; i < s.length(); i++)
        {
        if (i==s.length()/2)    
            System.out.print(s.charAt(i));
        else
            System.out.print(" ");
        }
    
    System.out.println();
    
    }
    
}
