//---------------------------------------------------------------------
// Christopher S. Gradwohl
// charTest.c
// tests the functionality of type char**
// practice allocating and freeing memory when using type char**
// practice reading a file into a string array
//---------------------------------------------------------------------

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include "List.h"
#define MAX_LEN 160

List insertionSort(char** A, int n){
    int j;
    List list = newList();

    // appends first element
    if ( n>0 ) append(list, 0);
    for ( j=1; j<n; j++ ){
        char *temp = A[j];
        int i = j - 1;
        moveFront(list);
        while( getindex(list)!=i ){
            moveNext(list);
        }
        while( i>-1 && strcmp(temp, A[get(list)])<0 ){
            i--;
            movePrev(list);
        }
        if(getindex(list) == -1){
            prepend(list, j);
        } else {
            insertAfter(list, j);
        }
    }
    return list;
}

// duplicates a string
char *strdup (const char *s) {
    char *d = malloc(strlen(s) + 1);
    if (d == NULL) return NULL;
    strcpy(d,s);
    return d;
}

//reads the file into an array of strings
char** read(FILE* inFile, int numLines){
    char** inFileArray = calloc(numLines, sizeof(char**));
    char line[MAX_LEN];
    for(int i = 0; i < numLines; i++){
        fgets(line, MAX_LEN, inFile);
        inFileArray[i] = strdup(line);
    }
    return inFileArray;
}

int main(int argc, char* argv[]){
    char line[MAX_LEN];
    int linecount = 0;
    int i;

    if(argc != 3) {
        printf("Invalid number of inputs");
        exit(1);
    }

    // opens input file from argv[1]
    FILE* input = fopen(argv[1], "r");
    // opens output file from argv[2]
    FILE* output = fopen(argv[2], "w");

    // use fgets() to count the number of lines
    while( fgets(line, MAX_LEN, input) != NULL) {
        linecount++;
    }

    // close input file to reset fgets() in function read()
    fclose(input);
    // re open input file
    input = fopen(argv[1], "r");

    // creates array of strings by reading from input file
    char** stringArray = read(input, linecount);

    List L = insertionSort(stringArray, linecount);

    moveFront(L);
    for( i=0; i<linecount; i++ ){
        fprintf(output, "%s", stringArray[get(L)]);
        moveNext(L);
    }

    fclose(input);
    fclose(output);

    for( i=0; i<linecount; i++ ){
        free(stringArray[i]);
    }
    free(stringArray);
    freeList(&L);
    return(0);
}
