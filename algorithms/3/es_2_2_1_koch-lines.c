#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include "libpsgraph.h"

void koch(int x, int n){
    if(n==0)
        draw(x);
    else {
        koch(x/3,n-1);
        turn(-60);
        koch(x/3,n-1);
        turn(120);
        koch(x/3,n-1);
        turn(-60);
        koch(x/3,n-1);
    }    
}

int main(void){
    int x,n;
    printf("Inserisci lunghezza e numero di Koch: ");
    scanf("%i%i", &x, &n);
    start("line.ps");
    koch(x,n);
    end();
    return EXIT_SUCCESS;
}
