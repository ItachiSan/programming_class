#include <stdio.h>
#include <stdlib.h>
#define LIMIT 10

int main(void){
    int counter = 1;
    while (counter <= LIMIT){
        printf("%i\n", counter*counter);
        counter++;
    }

    return 0;
}
