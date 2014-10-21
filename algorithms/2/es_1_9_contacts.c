#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <math.h>
#define LENGTH 1024

int main(int argc, char **argv){
    typedef struct {
    char nome[50]; // Name + surname, a really long string
    long int numero; // Should be fine for saving phone numbers
    } contatto; // The struct containing a normal phone number AKA ID String and Number

    contatto rubrica[LENGTH];
    char c=' ',string[50];
    int i=0,j;
    long int n=0;
    
    while(c != 'E'){
        printf("[A]ggiungi contatto/[M]ostra contatti/[E]sci: ");
        scanf(" %c\n", c);
        
        if(c=='A'){
            /* Saving a contact
            1) Getting infos and saving them into temporary buffers
            2) Associate them to
            */
            
            // 1)
            printf("Nome contatto %i: ", i);
            j=0; // Has to be resetted all the times
            while((c=getchar())!='\n' && c!='.')
                string[j++]=c;
            printf("Numero contatto %i: ", i);
            scanf(" %li", &n);
            
            // 2)
            
            
        } else if (c=='M') {
        }
    }
}
