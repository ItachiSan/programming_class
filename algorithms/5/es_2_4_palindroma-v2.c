#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

int main(int argc, char *argv[]){
    if(argv[1] != NULL){
        int i,j,k,test,l;
        for(i=1; i < argc; i++){
            l=strlen(argv[i]); /* String length */
            k=((strlen(argv[i])/2)+1); /* String half-size+1, useful to have less check for the string */
            for(j=0, test=1; test && j < k; j++)
                if(argv[i][j] != argv[i][l-j-1]) /* Avoid the last character (EOS) with the -1 */
                    test=0;
                    
            if(test){
                printf("%s: Palindroma\n", argv[i]);
            } else {
                printf("%s: Non palindroma\n", argv[i]);
        }

    }
    return EXIT_SUCCESS;
}
