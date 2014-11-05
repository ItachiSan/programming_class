#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

int smallest_word_index(char *s[], int n){
    int i,min;
    for(i=1, min=0; i < n ; i++)
        if(strcmp(s[i],s[min]) < 0)
            min=i;
    return min;
}

int main(void){
    char *dict[]={"ciao","mondo","come","funziona","bene","questo","programma"};
    int lun = 7, pos;
    pos = smallest_word_index(dict, lun);
    printf ( " La parola minima si trova in posizione %d .\n" , pos );

    return EXIT_SUCCESS;
}
