#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void){
    float radius,area;

    printf("Area del cerchio\n");
    printf("Raggio: ");
    scanf("%f", &radius);
    
    area = (radius*radius)*M_PI;
    
    printf("Area: %f\n", area);
    
    return 0;
}
