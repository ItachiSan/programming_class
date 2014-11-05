#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

void smallest_largest_fixed(char *s[], int n, int j, char **smallest, char **largest){
    int i=j,min,max;
    for(min=i+1, max=i+1; i < n ; i++){
        if(strcmp(s[i],s[min]) < 0)
            min=i;
        if(strcmp(s[i],s[max]) > 0)
            max=i;
    }
    *smallest = s[min];
    *largest = s[max];
}

int main(int argc, char *argv[]){
    char *piccola,*grossa;
    if(argv[1] != NULL){
        smallest_largest_fixed(argv, argc, 1, &piccola, &grossa);
        printf("Parola piu' piccola: %s\n" , piccola);
        printf("Parola piu' grossa: %s\n" , grossa);
    }
    return EXIT_SUCCESS;
}
