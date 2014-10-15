#include <stdio.h>
#include <stdlib.h>
#define LENGTH 100

int main(void){
    int array[LENGTH];
    printf("Inserisci una sequenza di interi\n");
    
    int i=0,j;
    int temp=-1;
    while(i < LENGTH){
        scanf(" %d", &temp);
        if(temp != 0){
            array[i]=temp;
            i++;
        }
        else
            break;
    }
    
    for(j=i-1;j >= 0;j--)
        printf("%d ",array[j]);
    printf("\n");
    
    return EXIT_SUCCESS;
}
