#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>


int main(int argc, char **argv){
    // Using typedef struct prevents me from using 'stuct MyStruct MyVariable' by using 'MyStruct MyVariable'
    
    typedef struct {
        float x;
        float y;
    } punto;
    
    typedef struct {
        punto v1;
        punto v2;
    } rettangolo;
    
    typedef struct {
        punto c;
        float r;
    } cerchio;

    // Real program
    char c=' ';
    while(c != 'C' && c != 'R'){
        printf("[R]ettangolo o [C]erchio? -> ");
        scanf(" %c", &c);
    }
    
    if(c=='R')
        {
        rettangolo rett;
        punto a,b;
        printf("Cordinata X vertice inferiore sinistro: ");
        scanf(" %f", &a.x);
        printf("Cordinata Y vertice inferiore sinistro: ");
        scanf(" %f", &a.y);
        printf("Cordinata X vertice superiore destro: ");
        scanf(" %f", &b.x);
        printf("Cordinata Y vertice superiore destro: ");
        scanf(" %f", &b.y);
        
        rett.v1=a;
        rett.v2=b;
        
        printf("Perimetro: %f\n", ((rett.v2.x-rett.v1.x)+(rett.v2.y-rett.v1.y))*2);
        printf("Area: %f\n", (rett.v2.x-rett.v1.x)*(rett.v2.y-rett.v1.y));
        }
    else
        {
        cerchio cerc;
        punto a;
        printf("Cordinata X centro: ");
        scanf(" %f", &a.x);
        printf("Cordinata Y centro: ");
        scanf(" %f", &a.y);
        printf("Raggio: ");
        scanf(" %f", &cerc.r);
        cerc.c=a;
        
        printf("Perimetro: %f\n", 2*cerc.r*M_PI);
        printf("Area: %f\n", cerc.r*cerc.r*M_PI);
        }

    return EXIT_SUCCESS;
}
