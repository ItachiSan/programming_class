#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define N 10

void stampa(int data[], int l){
    int i;
    for(i=0; i < l; i++)
        printf("%i ", data[i]);
    printf("\n");
}

void scambia(int a[], int i, int j){
    int t=a[i];
    a[i]=a[j];
    a[j]=t;
}

void selectionsort(int a[], int n){
    int i, max;
    /* Find the maximum */
    for(i=0, max=0; i < n; i++)
        if(a[max] < a[i])
            max=i;  
    /* Put the biggest at the end of the array */
    scambia(a, max, n-1);
    /* Recursion if the array is bigger than one element */
    if(n > 1)
        selectionsort(a, n-1);
}

void merge(int a[], int sx, int dx, int l){
    int i1=sx,i2=l+1,i3=0;
    int *b = malloc((dx-sx+1)*sizeof(int));
    /*
    First part of copy
    Insert lower values in the first places 
    */
    while(i1 <= l && i2 <= dx)
        if(a[i1] < a[i2])
            b[i3++]=a[i1++];
        else
            b[i3++]=a[i2++];
    /*
    Then copy other stuff at the end
    */
    if(i1 > l)
        while(i2 <= dx)
            b[i3++]=a[i2++];
    else
        while(i1 <= l)
            b[i3++]=a[i1++];
    /*
    Finally put stuff in the original array
    */    
    for(i3=0; i3 < dx-sx+1; i3++)
        a[sx+i3]=b[i3];
}

void mergesort(int a[], int sx, int dx){
    if(dx-sx > 0){
        int l=(dx+sx)/2;
        mergesort(a, sx, l);
        mergesort(a, l+1, dx);
        merge(a,sx,dx,l);
    }
}

int main(int argc, char *argv[]){
    int a[N], i=0, n;
    char c=' ';
    printf("Inserire %i elementi: ", N);
    
    while(i < N){
        scanf(" %i", &n);
        a[i++]=n;
    }
    
    printf("[M]erge sort/[S]election sort? ");
    while(c != 's' && c != 'm'){
        c=tolower(getchar());
    }
    
    if(c=='s')
        selectionsort(a,N);
    else
        mergesort(a,0,N-1);
    
    stampa(a,N);
    return EXIT_SUCCESS;    
}
