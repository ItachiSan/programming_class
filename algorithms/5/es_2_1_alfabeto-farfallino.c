#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

int main(int argc, char *argv[]){
    int i,j;
    for(i=1; i < argc; i++){
        for(j=0; j < strlen(argv[i]); j++)
            if(argv[i][j] == 'a' || argv[i][j] == 'e' || argv[i][j] == 'i' || argv[i][j] == 'o' || argv[i][j] == 'u')
                printf("%cf%c", argv[i][j], argv[i][j]);
            else
                printf("%c", argv[i][j]);
        printf(" ");
        }
    printf("\n");
    return EXIT_SUCCESS;
}
