#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void){
    double a,b,c,real,delta,complex;
    
    printf("Solver radici (a*x^2 + b*x + c = 0)\n");
    printf("a: ");
    scanf("%lf", &a);
    printf("b: ");
    scanf("%lf", &b);
    printf("c: ");
    scanf("%lf", &c);

    real = (-b)/(2.0*a);
    delta = (b*b)-(4*a*c);
    if (delta < 0){
        complex = sqrt(-delta)/(2.0*a);
        printf("a) %lf + i*%lf\n", real, complex);
        printf("b) %lf - i*%lf\n", real, complex);
    } else {
        complex = sqrt(delta)/(2.0*a);
        printf("a) %lf\n", (real + complex));
        printf("b) %lf\n", (real - complex));
    }

    return 0;
}
