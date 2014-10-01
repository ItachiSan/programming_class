#include <stdio.h>
#include <stdlib.h>

int main(void){
    int inserted=1,sum=0,count=0;
    
    while(inserted < 10){
        scanf("%i", &inserted);
        sum += inserted;
        if(inserted == 0) count--;
        }
    printf("%i\n", sum);
    
    return 0;
}
