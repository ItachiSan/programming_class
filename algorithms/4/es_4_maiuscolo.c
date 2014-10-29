#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define LENGTH 1024

char *maiuscolo(char *stringa){
    char *c=stringa;
    while(*c != '\0'){
        printf("%c\n", *c); // <- Lo spazio tra due parole viene considerato come terminatore di stringa
        if(*c >= 'a' && *c <= 'z')
            *c=toupper(*c);
        c++;
    }
    return stringa;
}

int main(void){
    char string[LENGTH];
    printf("Inserire la stringa da valutare: ");
    scanf("%s", string);
    printf("%s\n", maiuscolo(string));
    return EXIT_SUCCESS;
}
