#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "stack.h"

int main(int argc, char *argv[]){
    srand(time(NULL));
    int n=rand()%100,i=0;
    printf("%d\n", n);
    
    /*
        Stack should be empty at start
    */
    if(is_empty() != 1)
        return EXIT_FAILURE;
    printf("Test 1 ok\n");
    /*
        Stack should be empty after make_empty
    */        
    while(i<n){
        push(rand()%1000);
        i++;
    }
    make_empty();
    if(is_empty() != 1)
        return EXIT_FAILURE;
    printf("Test 2 ok\n");
    /*
        Stack should be empty after popping out everything
        And also, top()==pop()
    */        
    while(i < n){
        push(rand()%1000);
        i++;
    }
    int j,k;
    while(is_empty() != 1){
        j=top();
        k=pop();
        if(j != k)
            return EXIT_FAILURE;
    }
    printf("Test 3 ok\n");
    return EXIT_SUCCESS;
}
