#ifndef STACK_H
#define STACK_H
/*
    Header file for an integer stack
*/
void make_empty();
int is_empty();
int top();
int pop();
void push(int n);
#endif

#ifdef STACK_LIST
/*
    Definition of node for the node
*/
struct node {
    int num; /* valore dell’elemento */
    struct node *next; /* indirizzo del prossimo elemento */
};

typedef struct node node;
#endif
