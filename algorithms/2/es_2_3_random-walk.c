#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <time.h>
#define LENGTH 10

int main(void){
    char matrix[LENGTH][LENGTH],c='A';
    int i,j,k,dir[4]={0},go,walk=1;
    srand(time(NULL)); // Need a random seed here!
    // Fill the matrix
    for(i=0; i < LENGTH; i++)
        for(j=0; j < LENGTH; j++)
            matrix[i][j]='.';
    
    /* Gonna walk, set first char */
    i=0;
    j=0;
    matrix[i][j]=c++;
    while(walk && c <= 'Z'){
        /* Check if we've to walk */
        walk=0;
        for(k=0; k < 4; k++)
            if(dir[k]==0)
                walk=1;
        if(!walk)
            break;
        
        /* Let's walk! */
        go=rand()%4;
        switch(go){
            case 0:
                if(i > 0 && matrix[i-1][j]=='.')
                    {
                    matrix[--i][j]=c++;
                    for(k=0; k < 4; k++) dir[k]=0;
                    }
                else
                    dir[0]=1;
                break;
            case 1:
                if(j < LENGTH-1 && matrix[i][j+1]=='.')
                    {
                    matrix[i][++j]=c++;
                    for(k=0; k < 4; k++) dir[k]=0;
                    }
                else
                    dir[1]=1;
                break;
            case 2:
                if(i < LENGTH-1 && matrix[i+1][j]=='.')
                    {
                    matrix[++i][j]=c++;
                    for(k=0; k < 4; k++) dir[k]=0;
                    }
                else
                    dir[2]=1;
                break;
            case 3:
                if(j > 0 && matrix[i][j-1]=='.')
                    {
                    matrix[i][--j]=c++;
                    for(k=0; k < 4; k++) dir[k]=0;
                    }
                else
                    dir[3]=1;
                break;
        }
    }
    
    for(i=0; i < LENGTH; i++){
        for(j=0; j < LENGTH; j++)
            printf("%c",matrix[i][j]);
        printf("\n");
    }
    return EXIT_SUCCESS;
}
