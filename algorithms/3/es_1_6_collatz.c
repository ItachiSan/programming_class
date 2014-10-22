#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int collatz(int a){
    if(a%2==0)
        return a/2;
    else
        return (a*3)+1;
}

int main(void){
    int n,i=1;
    printf("Serie di Collatz di: ");
    scanf(" %i", &n);
    printf("%i ", n);
    while(n>1){
        n=collatz(n);
        i++;
        printf("%i ", n);
    }
    printf("\nLunghezza: %i\n", i);
    return EXIT_SUCCESS;
}
