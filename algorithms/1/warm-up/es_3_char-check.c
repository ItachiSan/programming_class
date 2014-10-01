#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(void){
    char choice;
    
    printf("Inserire carattere: ");
    scanf("%c", &choice);
    
    choice = tolower(choice);
    if (choice >= 'a' && choice <= 'z')
        if (choice != 'j' && choice != 'k' && choice != 'w' && choice != 'x' && choice != 'y')
            printf("La lettera e' dell'alfabeto italiano\n");
        else
            printf("La lettera non e' dell'alfabeto italiano\n");
    else
        printf("Il carattere non appartiene all'alfabeto\n");
    
    
    return 0;
}
