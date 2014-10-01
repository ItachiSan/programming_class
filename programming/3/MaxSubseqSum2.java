import java.util.*;

public class MaxSubseqSum2 {

    public static void main (String args[]) {    
    
    int a[] = {1,2,4,-8,2,-1,3,4};
    int sum=0;
    int temp;
    
    for (int i=0; i < a.length ; i++) {
        temp=0;
        for (int j=i; j < a.length ; j++) {
            temp+=a[j];
            if (sum < temp)
                sum=temp;
        }     
    }
    
    System.out.println(sum);
    
    }
    
}
