#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include "stack.h"

int main(int argc, char *argv[]){
    char token[10];
    int n1, n2;
    while(scanf("%s", token) != EOF){
        if(isdigit(token[0])){
            n1=atoi(token);
            push(n1);
        } else {
            switch(token[0]){
                case '+':
                    n1=pop();
                    n2=pop();
                    push(n1+n2);
                    break;
                case '-':
                    n1=pop();
                    n2=pop();
                    push(n1-n2);
                    break;
                case '/':
                    n1=pop();
                    n2=pop();
                    push(n1/n2);
                    break;
                case '*':
                    n1=pop();
                    n2=pop();
                    push(n1*n2);
                    break;
                case '=':
                    printf("\n%i\n", top());
            }
        }
    }
    return EXIT_SUCCESS;
}
