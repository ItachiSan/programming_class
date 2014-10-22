#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int potenza(int a, int b){
    int c=1;
    while(b-- > 0)
        c*=a;
    return c;
}

int main(void){
    int b,e;
    printf("Potenza: inserisci base e esponente -> ");
    scanf("%i%i", &b, &e);
    printf("Risultato: %i\n", potenza(b,e));
    return EXIT_SUCCESS;
}
