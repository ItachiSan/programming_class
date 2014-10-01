#include <stdio.h>
#include <stdlib.h>

int main(void){
    int inserted=1,sum=0,count=0;
    double media;
    
    scanf("%i", &inserted);
    
    while(inserted != 0){
        sum += inserted;
        count += 1;
        scanf("%i", &inserted);
        }
    
    media = ((float) sum / count);
    printf("%lf\n", media);
    
    return 0;
}
