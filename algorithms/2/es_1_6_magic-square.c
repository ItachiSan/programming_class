#include <stdio.h>
#include <stdlib.h>

int main(void){
    int n;
    printf("Inserire la dimensione del quadrato magico (n dispari): ");
    scanf("%d", &n);
    
    if(n%2 == 0){
        printf("Ho detto dispari!\n");
        return EXIT_FAILURE;
    }
    
    int square[n][n],i,j,k=1,end=0;
    
    // Reset the square
    for(i=0;i<n;i++)
        for(j=0;j<n;j++)
            square[i][j]=0;
    
    // Start the insertion
    i=0;
    j=n/2;
        
    while(!end){ // Fake boolean
        square[i][j]=k;
        k++;
        
        // Calculate new cohordinates
        i=(i+(n-1))%n;
        j=(j+1)%n;    

        if(square[i][j] != 0){
            if(square[(i+2)%n][(j+n-1)%n] == 0){
                i=(i+2)%n;
                j=(j+n-1)%n;
            } else {
            end=1;
            }
        }
    }
    
    for(i=0;i<n;i++){
        for(j=0;j<n;j++)
            printf("%d\t",square[i][j]);
        printf("\n");
    }
    
    // Valore teoricamente sempre esatto
    for(i=0,k=0;i<n;i++){
        k+=square[i][0];
    }

    // Vai di controlli
    int t;
    // Colonne
    for(i=0;i<n;i++){
        t=0;
        for(j=0;j<n;j++)
            t+=square[i][j];
        if(t != k)
            {
            printf("Errore nel controllo della colonna %d!\n", i);
            return EXIT_FAILURE;
            }
    }
    // Linee
    for(i=0;i<n;i++){
        t=0;
        for(j=0;j<n;j++)
            t+=square[j][i];
        if(t != k)
            {
            printf("Errore nel controllo della linea %d!\n", i);
            return EXIT_FAILURE;
            }
    }
    
    // Diagonale 1
    t=0;
    for(i=0;i<n;i++)
        t+=square[i][i];
    if(t != k){
        printf("Errore nel controllo della diagonale 1!\n");
        return EXIT_FAILURE;
    }

    // Diagonale 2
    t=0;
    for(i=0;i<n;i++)
        t+=square[n-(i+1)][i];
    if(t != k){
        printf("Errore nel controllo della diagonale 2!\n");
        return EXIT_FAILURE;
    }
    
    // Finiamo
    return EXIT_SUCCESS;
}
