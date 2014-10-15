#include <stdio.h>
#include <stdlib.h>
#define EXAMS 5
#define STUDENTS 5

int main(void){
    int array[STUDENTS][EXAMS];
    int i,j;
    for(i=0; i<STUDENTS; i++)
        for(j=0; j<EXAMS; j++){
            printf("Voto del %do esame dello studente %d: ", i+1, j+1);
            scanf("%d", &array[i][j]);
        }

    int t;
    for(i=0; i<STUDENTS; i++){
        t=0;
        for(j=0; j<EXAMS; j++)
            t+=array[i][j];
        t/=EXAMS;
        printf("Media dello studente %d: %d\n", i+1, t);
    }
    
    for(i=0; i<STUDENTS; i++){
        t=0;
        for(j=0; j<EXAMS; j++)
            t+=array[i][j];
        t/=EXAMS;
        printf("Media dello studente %d: %d\n", i+1, t);
    }
    
    return EXIT_SUCCESS;
}
