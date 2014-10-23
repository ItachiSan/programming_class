#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int main(void){
    int i,j,count[26]={0};
    char c;
    printf("Inserire la frase da valutare: ");
    while( (c=tolower(getchar())) != '.' && c != '\n')
        if(c >= 'a' && c <= 'z')
            count[c-'a']++;
    for(i=0; i < 26; i++){ // 26 is the length of the alphabeth
        printf("%c ",'A'+i);
        for(j=0;j<count[i];j++)
            printf("*");
        printf("\n");
    }
    return EXIT_SUCCESS;
}
