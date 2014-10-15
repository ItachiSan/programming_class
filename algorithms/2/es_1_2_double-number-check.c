#include <stdio.h>
#include <stdlib.h>

int main(void){
    int number;
    int digits[10] = {0};
    printf("Inserisci un numero: ");
    scanf("%d", &number);
    
    while(number != 0){
        digits[number%10]++;
        number/=10;
        }

    int i;    
    for(i=0;i < 10; i++)
        if(digits[i] > 1)
            printf("La cifra %d e' stata ripetuta %d volte\n", i, digits[i]);
    
    return EXIT_SUCCESS;
}
