#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

// Using typedef struct prevents me from using 'stuct MyStruct MyVariable' by using 'MyStruct MyVariable'
    
typedef struct {
    float x;
    float y;
} punto;
    
typedef struct {
    punto v1;
    punto v2;
} rettangolo;

    
rettangolo create_rettangolo(punto p1, punto p2){
    rettangolo rett;
    rett.v1=p1;
    rett.v2=p2;
    return rett;
}

void print_rettangolo(rettangolo *r){
    printf("Coordinate: (%f,%f),(%f,%f)\n", r->v1.x, r->v1.y, r->v2.x, r->v2.y);
}

float area_rettangolo(rettangolo *r){
    return (r->v2.x - r->v1.x)*(r->v2.y - r->v1.y);
}

void centro_rettangolo(rettangolo *r){
    printf("Centro: (%f,%f)\n", (r->v2.x - r->v1.x)/2, (r->v2.y - r->v1.y)/2);
}

void move_rettangolo(rettangolo *r, int x, int y){
    r->v1.x+=x;
    r->v1.y+=x;
    r->v2.x+=y;
    r->v2.y+=y;
}

int main(int argc, char **argv){
    // Real program

    punto a,b;
    printf("Cordinata X vertice inferiore sinistro: ");
    scanf(" %f", &a.x);
    printf("Cordinata Y vertice inferiore sinistro: ");
    scanf(" %f", &a.y);
    printf("Cordinata X vertice superiore destro: ");
    scanf(" %f", &b.x);
    printf("Cordinata Y vertice superiore destro: ");
    scanf(" %f", &b.y);

    rettangolo rett=create_rettangolo(a, b);
    print_rettangolo(&rett);
    printf("Area: %f\n", area_rettangolo(&rett));
    centro_rettangolo(&rett);
    

    return EXIT_SUCCESS;
}
