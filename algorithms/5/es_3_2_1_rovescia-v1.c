#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int main(int argc, char *argv[]){
    int i,n,*num;
    printf("Scrivi la dimensione dell'array: ");
    scanf(" %i", &n);
    num=malloc(n*sizeof(int));
    for(i=0; i < n; i++)
        scanf(" %i", &num[i]);
    for(i=n-1;i >=0; i--)
        printf("%i ", num[i]);
    printf("\n");
    return EXIT_SUCCESS;
}
