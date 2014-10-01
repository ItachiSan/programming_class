#include <stdio.h>
#include <stdlib.h>

int main(void){
    int a,b,c,sum1,sum2,sum3;
    
    printf("Checker triangolo (lati a,b,c -> equilatero/isoscele/scaleno)\n");
    printf("a: ");
    scanf("%i", &a);
    printf("b: ");
    scanf("%i", &b);
    printf("c: ");
    scanf("%i", &c);

    sum1 = a+b;
    sum2 = b+c;
    sum3 = a+c;
    
    if( c >= sum1 || a >= sum2 || b >= sum3 )
        printf("Non e' un triangolo\n");
    else
        if ( a == b && b == c )
            printf("Equilatero\n");
        else if ( a == b || b == c || a == c )
            printf("Isoscele\n");
        else
            printf("Scaleno\n");
    
    return 0;
}
