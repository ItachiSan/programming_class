#include <stdio.h>
#include <stdlib.h>
#define LENGTH 100

int main(void){
    int n,b,i=0;
    int digits[LENGTH]={0};
    printf("Inserisci base e modulo: ");
    scanf("%d%d.", &b, &n);    

    int j=n;
    while(j != 0){
        digits[i]=j%10;
        j/=10;
        i++;
    }
    
    int f=0,t=1;
    for(j=0;j<i;j++){
        f+=digits[j]*t;
        t*=b;
    }
    
    printf("Il numero %d in base %d equivale al numero %d in base 10\n", n, b, f);
    return EXIT_SUCCESS;
}
