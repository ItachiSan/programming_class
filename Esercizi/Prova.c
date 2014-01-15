# include <stdio.h>
# include <stdlib.h>

int main(int argc, char **argv) {
    // Parametro da CLI
    if (argc < 2)
        {
        printf("Inserire valore da CLI\n");
        exit(-1);
        }
            
    // Dati        
    int i, j;
    long long int k=0;
    int value = atoi(argv[argc - 1]); // 1o array di char, normalizzato a 0   
    
    printf("Dato: %i\n", value);
    
    // Calcolo
    for (i=0; i < value; i++)
        for (j=0; j < i; j++)
            k+=j;
    // Output
    printf("Risultato: %llu \n", k);
}
