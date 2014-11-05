#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

void smallest_largest(char *s[], int n, char **smallest, char **largest){
    int i,min,max;
    for(i=1, min=0, max=0; i < n ; i++){
        if(strcmp(s[i],s[min]) < 0)
            min=i;
        if(strcmp(s[i],s[max]) > 0)
            max=i;
    }
    *smallest = s[min];
    *largest = s[max];
}

int main(void){
    char *dict[]={"ciao","mondo","come","funziona","bene","questo","programma"};
    int lun = 7;
    char *piccola,*grossa;
    smallest_largest(dict, lun, &piccola, &grossa);
    printf("Parola piu' piccola: %s\n" , piccola);
    printf("Parola piu' grossa: %s\n" , grossa);
    return EXIT_SUCCESS;
}
