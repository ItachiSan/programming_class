#include <stdio.h>
#include <stdlib.h>
#define STACK_LIST
#include "stack.h"

/*
    List stuff
    For the "pure" stuff, look in 6th lesson folder
*/

node *list = NULL;

void make_empty(){
    node *temp1=list->next, *temp2;
    while(temp1 != NULL){
        temp2=temp1->next;
        free(temp1);
        temp1=temp2;
    }
    free(list);
    list=NULL;
}

int is_empty(){
    if(list == NULL)
        return 1;
    else
        return 0;
}

int top(){
    if(list != NULL)
        return list->num;
    else
        return -1;
}

void push(int n){
    node *nodo=malloc(sizeof(node));
    if(nodo==NULL)
        exit(1);
    nodo->num=n;
    nodo->next=list;
    list=nodo;
}

int pop(){
    int value=top();
    if(list != NULL && list->next != NULL){
        node *temp=list->next;
        free(list);
        list=temp;
    }
    return value;
}
