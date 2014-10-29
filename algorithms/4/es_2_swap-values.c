#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

void scambia(int *p, int *q){
    int temp=*p;
    *p=*q;
    *q=temp;
}

int main(void){
    int a,b;
    printf("Valore di a: ");
    scanf(" %i", &a);
    printf("Valore di b: ");
    scanf(" %i", &b);
    printf("Pre  -> a,b: %i,%i\n", a, b);
    scambia(&a, &b);
    printf("Post -> a,b: %i,%i\n", a, b);
    return EXIT_SUCCESS;
}
