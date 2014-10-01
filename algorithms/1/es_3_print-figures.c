#include <stdio.h>
#include <stdlib.h>

int main(void){
    int k,t;
    char c='0',temp_c;
    printf("Cifrario di Cesare\n");
    printf("Inserire la frase: ");
    scanf("%i", &k)
    k=k%26; // Evitiamoci problemi
    while(c != '.'){
        c=getchar();
        temp_c=c;
        if (temp_c >= 'A' && temp_c <= 'Z'){
            if ((temp_c+k) > 'Z')
                c= ('Z'-c)
        }
        }
}
