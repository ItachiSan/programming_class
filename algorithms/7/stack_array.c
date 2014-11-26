/*
    Integer stack implementation with a static array
*/
#define ARRAY_LENGTH 1024

int array[ARRAY_LENGTH] = {0};
int elem_n = 0;

void make_empty(){
    int i;
    for(i=0; i < ARRAY_LENGTH; i++)
        array[i]=0;
    elem_n=0;
}

int is_empty(){
    if(elem_n == 0)
        return 1;
    else
        return 0;
}

int top(){
    return array[elem_n];
}

int pop(){
    int temp=array[elem_n];
    array[elem_n--]=0;
    return temp;
}

void push(int n){
    if( elem_n+1 < ARRAY_LENGTH)
        array[++elem_n]=n;
}
