#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define N 100

void max_secondmax (int a[], int n, int *max, int *second_max){
    int i,t=a[0];
    // Max value
    for(i=0; i<n; i++)
        if(a[i]>t)
            t=a[i];
    *max=t;
    // The second maximum value
    t=a[0];
    for(i=0; i<n; i++)
        if(a[i]<*max)
            if(a[i]>t)
                t=a[i];
    *second_max=t;
}

int main(void){
    int array[N];
    printf("Inserisci una sequenza di interi terminata da 0\n");
    
    int i=0,j,k,temp=-1;
    while(i < N){
        scanf(" %d", &temp);
        if(temp != 0){
            array[i]=temp;
            i++;
        }
        else
            break;
    }
    
    max_secondmax(array, i, &j, &k);
    printf("Max,second_max: %i,%i\n", j, k);
    
    return EXIT_SUCCESS;
}
