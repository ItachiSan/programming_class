#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define LENGTH 100

int main(int argc, char **argv){
    char string[LENGTH];
    char c=' ';
    int i,length=0,palindroma=1;
    
    printf("Inserisci la stringa da valutare: ");
    while((c=getchar())!='\n' && c!='.')
        string[length++]=tolower(c); // Case-unsensitive FTW
    
    for(i=0; palindroma && i <= ((length/2)+1);i++)
        if(string[i] != string[length-i-1]) // Remember the -1; if not, at first test it'll catch garbage and fail
            palindroma=0;
    
    if(palindroma){
        printf("Palindroma\n");
        return EXIT_SUCCESS;
    } else {
        printf("Non palindroma\n");
        return EXIT_FAILURE;
    }
}
