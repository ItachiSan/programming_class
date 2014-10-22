#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int fibonacci(int n){
    if(n < 3) // Should be just for 1 and 2, but in this way we manage also negative numbers
        return 1;
    else
        return fibonacci(n-1)+fibonacci(n-2);
}

int main(void){
    int n;
    printf("Fibonacci di: ");
    scanf(" %i", &n);
    printf("%i\n", fibonacci(n));
    return EXIT_SUCCESS;
}
