#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>

struct node {
    int num; /* valore dell’elemento */
    struct node *next; /* indirizzo del prossimo elemento */
};

typedef struct node node;

node *insert(int n, node *h){
    node *nodo=malloc(sizeof(node));
    if(nodo==NULL)
        exit(1);
    nodo->num=n;
    nodo->next=h;
    return nodo;
}

void printList(node *h){
    if(h!=NULL){
        printf("%d ", h->num);
        printList(h->next);
    }
    else
        printf("\n");
}

int isMember(int n, node *h){
    if(h==NULL)
        return 0;
    else
        if(h->num == n)
            return 1;
        else
            return isMember(n,h->next);
}

node *delete(int n, node *h){
    node *temp;
    if(h != NULL)
        if(h->num == n){
            temp=h->next;
            free(h);
            return temp;
        } else {
            h->next=delete(n,h->next);
            return h;
        }
    else
        return NULL;
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
    free(h);
}

void printInv(node *h){
    if(h != NULL){
        if(h->next != NULL)
            printInv(h->next);
        printf("%i ",h->num);
    }
}

int main(int argc, char *argv[]){
    int n, count=0;
    char c;
    node *list = NULL;
    while( (c=getchar()) != 'f'){
    /* c e’ il prossimo carattere letto da standard input
    Il ciclo termina quando c'e' il carattere ’f’ */
        switch(c){
        /* Inserisce un numero, se e solo se non presente */
        case '+':
            scanf(" %i", &n);
            if(isMember(n,list) != 1)
                list=insert(n,list);
            count=length(list);
        break;
        /* Stampa l'intera lista */
        case 'p':
            printList(list);
        break;
        /* Verifica la presenza di un elemento nella lista */
        case '?':
            scanf(" %i", &n);
            printf("%i\n",isMember(n,list));
        break;
        /* Rimuove un nodo, se ne trova il numero */
        case '-':
            scanf(" %i", &n);
            list=delete(n,list);
            count=length(list);
        break;
        /* Stampa la lunghezza della lista */        
        case 'c':
            count=length(list); /* Aggiorna il dato, per sicurezza */
            printf("%i\n",count);
        break;
        /* Svuota la lista */
        case 'd':
            destroy(list);
            list=NULL;
            count=length(list);
        break;
        /* Stampa i valori nell'ordine inverso */
        case 'o':
            printInv(list);
            printf("\n"); /* Sistema la stampa */
        break;
        } // end switch
    } // end while
    return EXIT_SUCCESS;
}
