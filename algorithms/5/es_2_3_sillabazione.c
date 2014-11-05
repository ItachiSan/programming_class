#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

int main(int argc, char *argv[]){
    if(argv[1] != NULL){
        int i,j;
        for(i=1; i < argc; i++){
            for(j=0; j < strlen(argv[i])-1; j++)
                if(argv[i][j] >= argv[i][j+1])
                    printf("%c-",argv[i][j]);
                else
                    printf("%c",argv[i][j]);
        printf("%c ", argv[i][j]);
        }
    printf("\n");
    }
    return EXIT_SUCCESS;
}
