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
    append(L, 1);
    append(L, 2);
    append(L, 3);
    append(L, 4);

    List M = newList();
    append(M, 1);
    append(M, 2);
    append(M, 3);
    append(M, 4);

    printf("length of list: %d\n", length(L));
    printf("index position: %d\n", index(L));
    printf("front element: %d\n", front(L));
    printf("back element: %d\n", back(L));
    //printf("get cursor element: %d\n", get(L));
    printf("List L ?= List M: %d\n", equals(L, M));

}
