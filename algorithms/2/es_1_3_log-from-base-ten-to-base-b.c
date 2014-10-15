#include <stdio.h>
#include <stdlib.h>
#define LENGTH 100

int main(void){
    int n,b,i=0;
    int digits[LENGTH]={0};
    printf("Inserisci base e modulo: ");
    scanf("%d%d", &b, &n);    

    int j=n;
    while(j != 0){
        digits[i]=j%b;
        j/=b;
        i++;
    }
    
    printf("Il numero %d in base 10 equivale al numero ", n);
    for(j=i-1;j>=0;j--)
        printf("%d", digits[j]);
    printf(" in base %d\n", b);
    return EXIT_SUCCESS;
}
