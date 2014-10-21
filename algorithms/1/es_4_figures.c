#include <stdio.h>

int main(int argc, char **argv){
    int n,i,j;
    printf("Disegniniiiiiiiiii\nScrivi un intero: ");
    scanf("%i", &n);
    
    // Scrivi uno e adattalo per dominarli tuttiiiiiiiiii
    printf("\nPrimo disegno: Righe alterne\n");
    for(i=0; i < n; i++){
        for(j=0; j < n; j++)
            if(i%2 ==0)
                printf("+");
            else
                printf("o");
        printf("\n");
        }
    
    printf("\nSecondo disegno: Caratteri alterni\n");
    for(i=0; i < n; i++){
        for(j=0; j < n; j++)
            if((i+j)%2 ==0)
                printf("+");
            else
                printf("o");
        printf("\n");
        }

    printf("\nTerzo disegno: Triangoli\n");
    for(i=0; i < n; i++){
        for(j=0; j < n; j++)
            if(i < j)
                printf("+");
            else if (i == j)
                printf("|");
            else
                printf("o");
        printf("\n");
        }
   

    if(n%2!= 0){ // n e' dispari, disegnamo anche il rombo
    printf("\nQuarto disegno: Rombi\n");
    int k=n%2+1;
    for(i=0; i < n; i++){
        for(j=0; j < n; j++)
            if(i == k || j == k)
                printf("o");
            else if(j < k)
                if ((k-j) <= i%k) printf("o");
                else printf("|");
            else // if (j > k)
                if ((j-k) <= i%k) printf("o");
                else printf("|");                
        printf("\n");
        }   
    }

    
    return 0;
}
