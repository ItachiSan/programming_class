import java.util.*;

public class MaxSubseqSum1 {

    public static void main (String args[]) {    
    
    int a[] = {1,2,4,-8,2,-1,3,4};
    int sum=0;
    int temp;
    
    for (int i=0; i < a.length ; i++) {
        for (int j=i; j < a.length ; j++) {
            temp=0;
            for (int k=i; k <= j; k++)
                temp += a[k];
            if (sum < temp)
                sum=temp;
        }     
    }
    
    System.out.println(sum);
    
    }
    
}
