#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int main(int argc, char *argv[]){
    int i=-1,j=0,k=2,*num;
    num=malloc(2*sizeof(int));
    while(i != 0) {
        scanf(" %i", &i);
        num[j++]=i;
        if(j == k){
            k+=2;
            num=realloc(num, k*sizeof(int));
        }
    }
    
    for(i=j;i >= 0; i--)
        if(num[i] != 0)
            printf("%i ", num[i]);
    printf("\n");
    return EXIT_SUCCESS;
}
