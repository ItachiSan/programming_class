#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int main(void){
    int k,t;
    char c='0';
    printf("Cifrario di Cesare\n");
    printf("Inserire la frase: ");
    scanf("%i ", &k);
    k=k%26; // Evitiamoci problemi
    while( (c=getchar()) != '.' && c != '\n'){
        t=tolower(c) - 'a';
	t=(t+k)%26;
	if(c >= 'a' && c <= 'z') c='a'+t;
	if(c >= 'A' && c <= 'Z') c='A'+t;
	putchar(c);
        }
    printf("\n");
    return 0;
}
