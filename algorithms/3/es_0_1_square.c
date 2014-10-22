#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

#include "libpsgraph.h"
int main(void){
    start("quadrato.ps");
    draw(50);
    turn(90);
    draw(50);
    turn(90);
    draw(50);
    turn(90);
    draw(50);
    end();
    return EXIT_SUCCESS;
}
