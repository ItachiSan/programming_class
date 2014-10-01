#include <stdio.h>
#include <stdlib.h>

int main(void){
    int inserted=1,sum=0;
    
    scanf("%i", &inserted);
    
    while(inserted != 0){
        sum += inserted;
        scanf("%i", &inserted);
        }
    printf("%i\n", sum);
    
    return 0;
}
