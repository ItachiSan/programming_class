#include <stdio.h>
#include <stdlib.h>
#define LENGTH 100

int main(void){
    int array[LENGTH];
    printf("Inserisci una sequenza di interi\n");
    
    int i=0,j=1,*k;
    int temp=-1;
    while(j){
        scanf(" %d", &temp);
        if(temp != 0){
            array[i]=temp;
            i++;
        }
        else
            j=0;
    }
    
    for(k= &array[i-1];k >= &array[0];k--)
        printf("%d ", *k);
    printf("\n");
    
    return EXIT_SUCCESS;
}
