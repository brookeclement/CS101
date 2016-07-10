//-----------------------------------------------------------------------------
//  ListTest.c
//  Christopher S. Gradwohl
//  cgradwoh
//  pa2
//  List.c (ListADT) test client
//-----------------------------------------------------------------------------

#include<stdio.h>
#include"List.h"

int main(int argc, char* argv[]){
    List L = newList();
    append(L,5);
    append(L,6);
    append(L,7);
    moveFront(L);
    fprintf(stdout, "getindex()= %d", getindex(L));
    moveNext(L);
    fprintf(stdout, "getindex()= %d", getindex(L));
    moveNext(L);
    fprintf(stdout, "getindex()= %d", getindex(L));
    moveNext(L);
    fprintf(stdout, "getindex()= %d", getindex(L));
    moveNext(L);
    fprintf(stdout, "getindex()= %d", getindex(L));
}
