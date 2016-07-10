#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(int argc, char * argv[]){
    //SEG FAULT: 11 :)
    /*char* A = NULL;
    char* B = "abc";
    int result = strcmp(A, B)>0;
    fprintf(stdout, "%d", result);*/

    char* A = "three";
    char* B = "two";
    int result = strcmp(A, B);
    //while( result>=0 ){
        fprintf(stdout, "%d", result);
    //}
}
