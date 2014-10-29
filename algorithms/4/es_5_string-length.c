#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define LENGTH 1024

int lung_stringa(char *s){
    int n=0;
    char *c=s;
    while(*c != '\0'){
        n++;
        c++;
    }
    return n;
}

int main(void){
    char string[LENGTH];
    printf("Scrivere una stringa: ");
    scanf("%s", string);
    int length = lung_stringa(string);
    printf("Lunghezza di '%s' : %i\n", string, length);
    return EXIT_SUCCESS;
}
