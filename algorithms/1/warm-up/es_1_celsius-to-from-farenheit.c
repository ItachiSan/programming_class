#include <stdio.h>
#include <stdlib.h>

int main(void){
    double temp;
    char choice = 'a';
    
    // Scelgo la conversione
    printf("Farenheit [f]/Celsius [c]? ");
    while(choice != 'c' && choice != 'f')
        scanf("%c", &choice);
    
    printf("Temperatura: ");
    scanf("%lf", &temp);
    
    if(choice == 'c')
        temp = (temp-32.0)/(9.0/5.0);
    else
        temp = (temp*(9.0/5.0))+32.0;
    
    printf("Temperatura convertita: %lf\n", temp);
    
    return 0;
}
