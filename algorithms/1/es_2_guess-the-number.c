#include <stdio.h>
#include <stdlib.h>
#define UP 1000
#define LOW 0
#define MIDDLE 500

int main(void){
    int up=UP,low=LOW,guess=MIDDLE;
    char c='0';

    while ( c != '=') {
        printf("Il numero e' %i? ", guess);
        scanf(" %c", &c);
        
        if ( c == '<') { 
            up=guess;
            guess=(up-low)/2+low;
        }
        else if ( c == '>') {
            low=guess;
            guess=up-((up-low)/2);
        }
        else if ( c != '=')
            printf("Errore, reinserisci\n");       
    }
    
    return 0;
}
