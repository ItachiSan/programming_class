#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int primo(int a){
    int i,v=1;
    for(i=2; v==1 && i < (a/2+1); i++)
        if(a%i==0)
            v=0;
    return v;
}

int main(void){
    int i;
    printf("Inserisci il numero da valutare: ");
    scanf(" %i", &i);
    if(primo(i)==1){
        printf("Numero primo\n");
        return EXIT_SUCCESS;
    } else {
        printf("Numero non primo\n");
        return EXIT_FAILURE;
    }
}
