#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <time.h>
#define LIMIT 100

void riempi_array(int a[], int n){
    srand(time(NULL));
    int i;
    for(i=0;i<n;i++)
        a[i]=rand()%LIMIT;
}

int somma_array(int a[], int n){
    int c=0,i;
    for(i=0;i<n;i++)
        c+=a[i];
    return c;
}

int main(void){
    srand(time(NULL));
    int n=((rand()%LIMIT)+1),i;
    int numeri[n];
    printf("Lunghezza array: %i\n", n);
    riempi_array(numeri, n);
    printf("Contenuto array:\n");
    for(i=0;i < n; i++)
        printf("%i,",numeri[i]);
    printf("\n");
    printf("Somma degli elementi: %i\n", somma_array(numeri,n));
    return EXIT_SUCCESS;
}
