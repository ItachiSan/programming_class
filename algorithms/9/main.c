#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

#include "solvers.h"

int main(int argc, char *argv[]){
    // jp = original_jp / 1000
    int objs = 11;
    int jp[] = {20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
    int swindels[] = {100, 107, 124, 133, 139, 155, 172, 178, 184, 190, 195};
    int num;
    
    printf("Inserire il numero di jet-points: ");
    scanf("%i", &num);
    
    int *values = malloc((num+1) * sizeof(int));
    int i;
    for(i=0; i <= num; i++)
        values[i]=0;
    
    int solution = knapsack_simple(num, objs, swindels, jp, values);
    printf("Valore in swindels: %i\n", solution);
    free(values);
    
    return EXIT_SUCCESS;
}
