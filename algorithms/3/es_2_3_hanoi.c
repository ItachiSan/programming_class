#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

void hanoi(int n, int from, int temp, int to){
    if(n==1)
        printf("%i->%i\n", from, to);
    else
        {
        hanoi(n-1,from,to,temp);
        printf("%i->%i\n", from, to);
        hanoi(n-1,temp,from,to);
        }
}

int main(void){
    int n;
    printf("Torri di Hanoi: ");
    scanf("%i", &n);
    hanoi(n,0,1,2);
    return EXIT_SUCCESS;
}
