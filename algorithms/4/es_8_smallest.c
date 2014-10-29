#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define N 100

int *smallest(int a[], int n){
    int i,*t=a;
    // Max value
    for(i=0; i<n; i++)
        if(a[i]<*t)
            t=&a[i];
    return t;
}

int main(void){
    int array[N];
    printf("Inserisci una sequenza di interi terminata da 0\n");
    
    int i=0,temp=-1;
    while(i < N){
        scanf(" %d", &temp);
        if(temp != 0){
            array[i]=temp;
            i++;
        }
        else
            break;
    }
    
    printf("Valore minimo: %i\n", *smallest(array, i));
    
    return EXIT_SUCCESS;
}
