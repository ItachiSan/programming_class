#include <stdio.h>
#include <stdlib.h>

int main(void){
    char a='0', b='0';
    while( a < 'A' || a > 'Z' )
        scanf("%c", &a);
    while( b < 'A' || b > 'Z' )
        scanf("%c", &b);
    
    printf("%i\n", a-b);
    return 0;
}
