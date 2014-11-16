#include <stdio.h>

int main(int argc, char **argv){
    int n,i,j;
    printf("Disegniniiiiiiiiii\nScrivi un intero: ");
    scanf("%i", &n);
    
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
   

    if(n%2!= 0){
    printf("\nQuarto disegno: Rombi\n");
    int k=n/2;
    for(i=0; i < n; i++){
        for(j=0; j < n; j++)
            if(i < k)
                if (j < k)
                    if ((k-j) <= i) printf("o");
                    else printf("|");
                else
                    if ((j-k) <= i) printf("o");
                    else printf("|");     
            else
                if (j < k)
                    if ((k-j) <= n-i-1) printf("o");
                    else printf("|");
                else
                    if ((j-k) <= n-i-1) printf("o");
                    else printf("|");               
        printf("\n");
        }   
    }

    
    return 0;
}
