#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int latoCristallo(int l){
    if(l == 0)
        return 1;
    else
        return 1 + 2 * latoCristallo(l-1);
}

char **creaMatrice(int n){
    char **matrix;
    int i;
    matrix=malloc(n*sizeof(char *));
    for(i=0; i < n; i++)
        matrix[i]=malloc(n*sizeof(char));
    return matrix;
}

void stampaMatrice(char **m, int n){
    int i,j;
    for(i=0; i < n; i++){
        for(j=0; j < n; j++)
            printf("%c", m[i][j]);
        printf("\n");
    }
}

void crist(char **m, int r0, int c0, int l){
    if(l == 1)
        m[r0][c0]='*';
    else
        {
            int i,c=l/2;
            for(i=0;i < l; i++){
                m[c][i]='.';
                m[i][c]='.';
            }
            m[c][c]='*';
            crist(m, 0,   0,   c-1);
            crist(m, c+1, 0,   c-1);
            crist(m, 0,   c+1, c-1);
            crist(m, c+1, c+1, c-1);
        }
} 

/*
void crist(char **m, int r0, int c0, int l){
    int i,j;
    for(i=r0; i < l; i++)
        for(j=c0; j < l; j++)
            m[i][j]='o';
} 
*/

void cristallo(char **m, int l){
    crist(m,0,0,l);
}

int main(int argc, char *argv[]){

    char **matrix ;
    int t, lato ;
    scanf("%d" , &t); // legge il tempo
    if(t >= 0 ){
        lato = latoCristallo(t); // dimensione della matrice
        printf("%d\n", lato);
        matrix = creaMatrice(lato); // crea matrice per rappresentare il cristallo
        cristallo(matrix, t); // costruisce il cristallo avente lato assegnato
        stampaMatrice(matrix, lato); // stampa la matrice
    }

    return EXIT_SUCCESS;
}
