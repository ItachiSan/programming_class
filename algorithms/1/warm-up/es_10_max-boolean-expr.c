#include <stdio.h>
#include <stdlib.h>

int main(void){
    int a,b,c;
    scanf("%i", &a);
    scanf("%i", &b);
    c = (a > b) ? a : b;
    printf("%i\n", c);
    return 0;
}
