#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

void *my_malloc(int i){
    void *memory;
    memory = malloc(i*sizeof(int));
    if(memory == NULL){
        printf("Errore nell'allocazione della memoria!\n");
        exit(1);
    }
    return memory;
}

void *my_realloc(void *mem, int i){
    void *memory;
    memory = realloc(mem, i*sizeof(int));
    if(memory == NULL){
        printf("Errore nell'allocazione della memoria!\n");
        exit(1);
    }
    return memory;
}

int main(int argc, char *argv[]){
    void *memoria;
    unsigned int i;
    printf("Inserisci il numero di blocchi di 4 bytes da allocare: ");
    scanf(" %u", &i);
    memoria=my_malloc(i);
    printf("Memoria allocata!\n");
    printf("Nuova dimensione a blocchi di 4 bytes della memoria dinamica: ");
    scanf(" %u", &i);
    memoria=my_realloc(memoria,i);
    printf("Memoria riallocata!\n");
    return EXIT_SUCCESS;
}
