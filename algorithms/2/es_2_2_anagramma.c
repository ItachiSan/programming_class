#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int main(void){
    int i,count1[26]={0},count2[26]={0};
    char c;
    // 1st input
    printf("Inserire la prima frase da valutare: ");
    while( (c=tolower(getchar())) != '.' && c != '\n')
        if(c >= 'a' && c <= 'z')
            count1[c-'a']++;
    // 2nd input
    printf("Inserire la seconda frase da valutare: ");
    while( (c=tolower(getchar())) != '.' && c != '\n')
        if(c >= 'a' && c <= 'z')
            count2[c-'a']++;
    // Check
    for(i=0; i < 26; i++) // 26 is the length of the alphabeth
        if(count1[i] != count2[i]){
            printf("Non e' un anagramma\n");
            return EXIT_FAILURE;
        }
    printf("E' un anagramma\n");
    return EXIT_SUCCESS;
}
