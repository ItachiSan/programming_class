#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int main(int argc, char *argv[]){
    int i=-1,j=0,k=0,*num;
    num=malloc(2*sizeof(int));
    while(i != 0) {
        scanf(" %i", &i);
        num[(k*2)+(j++)]=i;
        if(j == 2){
            num=realloc(num, (++k)*2*sizeof(int));
            j=0;
        }
    }
    
    for(i=k*2+j;i >=0; i--)
        printf("%i ", num[i]);
    printf("\n");
    return EXIT_SUCCESS;
}
