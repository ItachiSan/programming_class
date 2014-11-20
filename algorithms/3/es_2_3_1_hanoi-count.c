#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

int hanoi(int n){
    if(n==1)
        return 1;
    else
        return 1 + 2*hanoi(n-1);
}

int main(void){
    int n,m=0;
    printf("Torri di Hanoi: ");
    scanf("%i", &n);
    m=hanoi(n);
    printf("Mosse per %i blocchi: %i\n", n, m);
    return EXIT_SUCCESS;
}
