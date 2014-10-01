import java.util.*;

public class ProdInternoArray {

    public static void main (String args[]) {    
    
    //int[] a = new int[4];
    int[] a = {1,3,5,7};
    int[] b = {8,4,6,2};
    int sum = 0;
    
    // int l = (a.length>=b.length) ? a.length : b.length;
    
    for (int i=0; i < a.length; i++)
        sum += (a[i]*b[i]);
        
    System.out.println(sum);
    }
    
}
