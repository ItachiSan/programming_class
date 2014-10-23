#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <time.h>
#define LENGTH 10

int main(void){
    char matrix[LENGHT][LENGTH];
    int i,j;
    srand(time(NULL)); // Need a random seed here!
    // Fill the matrix
    for(i=0,i<LENGHT,i++)
        for(j=0,j<LENGHT,j++)
            matrix[i][j]='.';
    return EXIT_SUCCESS;
}
