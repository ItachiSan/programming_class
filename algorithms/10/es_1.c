#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#include <time.h>
#define SIZE 10

struct Bit_node {
    //Item item;
    int item;
    struct Bit_node *l, *r;
};

typedef struct Bit_node *bit_node;

//bit_node bit_new(Item i){
bit_node bit_new(int i){
    bit_node new = malloc(sizeof(bit_node));
    new->item=i;
    return new;
}

void bit_printitem(bit_node b){
    //print_item_function(b->item);
    printf("%d ", b->item);
}

void bit_preorder(bit_node b){
    if( b ){ // if (b != NULL)
        bit_printitem(b);
        bit_preorder(b->l);
        bit_preorder(b->r);
    }
}

void bit_inorder(bit_node b){
    if( b ){
        bit_inorder(b->l);
        bit_printitem(b);
        bit_inorder(b->r);
    }
}

void bit_postorder(bit_node b){
    if( b ){
        bit_postorder(b->l);
        bit_postorder(b->r);
        bit_printitem(b);
    }    
}

void bit_printassummary(bit_node b, int spaces){
    if( b ){
        int i;
        for(i=0; i < spaces; i++)
            printf(" ");
        
        //printf("*"); printitem(b); printf("\n");
        printf("*%d\n", b->item); // Item = int
        bit_printassummary(b->l, spaces+1);
        bit_printassummary(b->r, spaces+1);
    }
}

//bit_node bit_arr2tree(Item a[], int size, int i)
bit_node bit_arr2tree(int a[], int size, int i){
    if(i < size){
        bit_node new = bit_new(a[i]);
        new->l = bit_arr2tree(a, size, 2*i + 1);
        new->r = bit_arr2tree(a, size, 2*i + 2);
        return new;
    } else return NULL;
}

int main(int argc, char *argv[]){
    srand(time(NULL));
    int a[SIZE], i;
    for(i=0; i < SIZE; i++)
        //a[i]=rand();
        // Let's read stuff
        a[i]=rand()%100;
    
    bit_node tree = bit_arr2tree(a, SIZE, 0);
    bit_printassummary(tree, 0);
    
    printf("Stampa in preordine\n");
    bit_preorder(tree);
    printf("\n");
    
    printf("Stampa in ordine\n");
    bit_inorder(tree);
    printf("\n");
    
    printf("Stampa in postordine\n");
    bit_postorder(tree);
    printf("\n");
    
    return EXIT_SUCCESS;
}
