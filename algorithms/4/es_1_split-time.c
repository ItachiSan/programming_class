#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

void split_time(long int tot_sec, int *h, int *m, int *s){
    *h=(tot_sec/3600);
    *m=(tot_sec%3600)/60;
    *s=(tot_sec%3600)%60;
}

int main(void){
    long int time;
    int hour, minutes, seconds;
    printf("Scrivere il tempo complessivo in secondi: ");
    scanf("%li", &time);
    split_time(time, &hour, &minutes, &seconds);
    printf("Conversione: %i ore, %i minuti, %i secondi\n", hour, minutes, seconds);
    return EXIT_SUCCESS;
}
