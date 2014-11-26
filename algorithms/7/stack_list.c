#include <stdio.h>
#include <stdlib.h>
#define STACK_LIST
#include "stack.h"

/*
    List stuff
    For the "pure" stuff, look in 6th lesson folder
*/

node *list = NULL;

void insert(int n, node *h){
    node *nodo=malloc(sizeof(node));
    if(nodo==NULL)
        exit(1);
    nodo->num=n;
    nodo->next=h;
    h=nodo;
}

void delete(node *h){
    if(h != NULL && h->next != NULL){
        node *temp=h->next;
        free(h);
        h=temp;
    }
}

int length(node *h){
    if(h == NULL)
        return 0;
    else
        return length(h->next) + 1;
}

void destroy(node *h){
    if(h->next != NULL)
        destroy(h->next);
    if(h != NULL)
        free(h);
}

/*
    Stack stuff
*/

void make_empty(){
    destroy(list);
}

int is_empty(){
    if(length(list) == 0)
        return 1;
    else
        return 0;
}

int top(){
    return list->num;
}

int pop(){
    int temp=top();
    delete(list);
    return temp;
}

void push(int n){
    insert(n,list);
}
