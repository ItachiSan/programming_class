import java.util.*;

public class SommaArray {

    public static void main (String args[]) {    
    
    //int[] a = new int[4];
    int[] a = {1,3,5,7};
    int[] b = {8,4,6,2};
    int[] c = {0,0,0,0};
    
    // int l = (a.length>=b.length) ? a.length : b.length;
    
    for (int i=0; i < a.length; i++)
        c[i] = (a[i]+b[i]);
        
    System.out.print("{");
    for (int i=0; i < a.length-1; i++)
        System.out.print(c[i]+", ");
    System.out.println(c[a.length-1]+"}");
    }
    
}
