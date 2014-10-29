#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define LENGTH 100

int main(int argc, char **argv){
    char string[LENGTH],*i;
    char c=' ';
    int length=0,palindroma=1;
    
    printf("Inserisci la stringa da valutare: ");
    while((c=getchar())!='\n' && c!='.')
        string[length++]=tolower(c); // Case-unsensitive FTW
    
    for(i=string; palindroma && i <= i+(*(string+length)-*i); i++)
        if(*i != *(i+(*(string+length)-*i)))
            palindroma=0;
    
    if(palindroma){
        printf("Palindroma\n");
        return EXIT_SUCCESS;
    } else {
        printf("Non palindroma\n");
        return EXIT_FAILURE;
    }
}
