#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

char swap_vocale(char a, char b){
    if(b=='a' || b=='e' || b=='i' || b=='o' || b=='u')
        return a;
    else
        return b;
}

int main(void){
    char c,d;
    printf("Inserire la frase: ");
    scanf(" %c ", &c);
    while((d=getchar()) != '.' && d != '\n')
        printf("%c", swap_vocale(c,d));
    printf("\n");
    return EXIT_SUCCESS;
}
