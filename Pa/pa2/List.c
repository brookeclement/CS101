//-----------------------------------------------------------------------------
//  List.c
//  Christopher S. Gradwohl
//  cgradwoh
//  pa2
//  ListADT for the Lex.c client using a doubley linked list
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include "List.h"

// ---------------------------
// structs
// ---------------------------

// private NodeObj type
typedef struct NodeObj{
    int data;
    struct NodeObj* prev;
    struct NodeObj* next;
} NodeObj;

// private Node type
typedef struct NodeObj* Node;

// private ListObj type
typedef struct ListObj{
    Node front;
    Node back;
    Node cursor;
    int length;
    int index;
} ListObj;

// ---------------------------
// constructors - destructors
// ---------------------------

// private newNode()
// returns a new Node object and initializes Node objects next, prev and data fields
Node newNode(int data){
    Node N = malloc(sizeof(NodeObj));
    N->data = data;
    N->prev = NULL;
    N->next = NULL;
    return(N);
}

// private freeNode()
// frees the heap memory pointed to by *pN, then sets *pN to NULL
void freeNode(Node* pN){
    if( pN!=NULL && *pN!=NULL ){
       free(*pN);
       *pN = NULL;
    }
}

// public newList()
// returns new empty List object
List newList(void){
    List L;
    L = malloc(sizeof(ListObj));
    L->front = NULL;
    L->front = NULL;
    L->cursor = NULL;
    L->length = 0;
    L->index = -1;
    return(L);
}

// public freeList()
// frees the heap memory pointed to by *pL, then sets *pL to NULL
void freeList(List* pL){
    if( *pL!=NULL && pL!=NULL ){
        while( length(*pL)>0 ){
            deleteFront(*pL);       // have to make deleteFront perfrom front = front.next;
        }
        free(*pL);
        *pL = NULL;
    }
}

// ---------------------------
// Access Functions
// ---------------------------

// Returns the number of elements in this List.
// Pre: none
int length(List L){
    if( L==NULL ){
        printf("List Error: cannot call length() on empty List");
        exit(1);
    }
    return(L->length);
}

// If cursor is defined, returns the index of the cursor element,
// otherwise returns -1.
// Pre: none
int index(List L){
    if( L==NULL ){
        printf("List Error: cannot call index() on NULL List referenece\n");
        exit(1);
    }
    return(L->index);
}

// Returns front element.
// Pre: length()>0
int front(List L){
    if( L==NULL ){
        printf("List Error: cannot call front() on NULL List referenece\n");
        exit(1);
    }
    if ( L->length<=0 ){
        printf("List Error: cannot call front() on empty List\n");
        exit(1);
    }
    return(L->front->data);
}

// Returns back element.
// Pre: length()>0
int back(List L){
    if( L==NULL ){
        printf("List Error: cannot call back() on NULL List referenece\n");
        exit(1);
    }
    if ( L->length<=0 ){
        printf("List Error: cannot call back() on empty List\n");
        exit(1);
    }
    return(L->back->data);
}

// Returns cursor element.
// Pre: length()>0, index()>=0
int get(List L){
    if( L==NULL ){
        printf("List Error: cannot call get() on NULL List referenece\n");
        exit(1);
    }
    if ( L->length<=0 ){
        printf("List Error: cannot call get() on empty List\n");
        exit(1);
    }
    if( L->index<0 ){
        printf("List Error: cannot call get() on undefined cursor position\n");
        exit(1);
    }
    return(L->cursor->data);
}

// Returns true (1) if List A and B are the same integer
// sequence and returns false (0) otherwise.
// Pre: none
int equals(List A, List B){
    int eq = 0;
    Node N = NULL;
    Node M = NULL;

    if( A==NULL || B==NULL ){
       printf("List Error: calling equals() on NULL List reference\n");
       exit(1);
    }

    eq = ( A->length == B->length );
    N = A->front;
    M = B->front;
    while( eq && N!=NULL){
       eq = (N->data==M->data);
       N = N->next;
       M = M->next;
    }
    return eq;
}

// ---------------------------
// Manipulation Procedures
// ---------------------------

// Resets this List to its original empty state.
// Pre: none
void clear(List L){
    if( L==NULL ){
        printf("List Error: calling clear() on NULL List reference");
        exit(1);
    }

    //Function clear() should have a loop that calls deleteFront() or
    // deleteBack() while the list is not empty.

    L->front = NULL;
    L->back = NULL;
    L->cursor = NULL;
    L->length = 0;
    L->index = -1;
}

// If List is non-empty, places the cursor under the front element,
// otherwise does nothing.
// Pre: none
void moveFront(List L){
    if( L==NULL ){
        printf("List Error: calling moveFront() on NULL List reference");
        exit(1);
    }
    if( L->length>0 ){
        L->cursor = L->front;
        L->index = 0;
    }
}

// If List is non-empty, places the cursor under the back element,
// otherwise does nothing.
// Pre: none
void moveBack(List L){
    if( L==NULL ){
        printf("List Error: calling moveBack() on NULL List reference");
        exit(1);
    }
    if( L->length>0 ){
        L->cursor = L->back;
        L->index = L->length - 1;
    }
}

// If cursor is defined and not at front, moves cursor one step toward
// front of this List, if cursor is defined and at front, cursor becomes
// undefined, if cursor is undefined does nothing.
// Pre: none
void movePrev(List L){
    if( L==NULL ){
        printf("List Error: calling movePrev() on NULL List reference");
        exit(1);
    }
    if( L->cursor!=NULL && L->cursor!=L->front ){
        L->cursor = L->cursor->prev;
        L->index--;
    }else if( L->cursor!=NULL && L->cursor==L->front ){
        L->cursor = NULL;
        L->index = -1;
    }else if( L->cursor==NULL ){
        L->cursor = NULL;
        L->index = -1;
    }
}

// If cursor is defined and not at back, moves cursor one step toward
// back of this List, if cursor is defined and at back, cursor becomes
// undefined, if cursor is undefined does nothing.
// Pre: none
void moveNext(List L){
    if( L==NULL ){
        printf("List Error: calling moveNext() on NULL List reference");
        exit(1);
    }
    if( L->cursor!=NULL && L->cursor!=L->back ){
        L->cursor = L->cursor->next;
        L->index++;
    }else if( L->cursor!=NULL && L->cursor==L->back ){
        L->cursor = NULL;
        L->index = -1;
    }else if ( L->cursor==NULL ){
        L->cursor = NULL;
        L->index = -1;
    }
}

// Insert new element into this List. If List is non-empty,
// insertion takes place before front element.
// Pre: none
void prepend(List L, int data){
    if( L==NULL ){
        printf("List Error: calling prepend() on NULL List reference");
        exit(1);
    }
    Node N = newNode(data);
    if( L->length==0 ){
        L->front = N;
        L->back = N;
    }else{
        L->front->prev = N;
        N->next = L->front;
        L->front = N;
    }
    L->length++;

}

// Insert new element into this List. If List is non-empty,
// insertion takes place after back element.
// Pre: none
void append(List L, int data){
    if( L==NULL ){
        printf("List Error: calling append() on NULL List reference");
        exit(1);
    }
    Node N = newNode(data);
    if( L->length==0 ){
        L->front = N;
        L->back = N;
    }else{
        L->back->next = N;
        N->prev = L->back;
        L->back = N;
    }
    L->length++;
}

// Insert new element before cursor.
// Pre: length()>0, index()>=0
void insertBefore(List L, int data){
    if( L==NULL ){
        printf("List Error: insertBefore() called on NULL List reference");
        exit(1);
    }
    if( L->length<=0 ){
        printf("List Error: insertBefore() called on empty List");
        exit(1);
    }
    if( L->index<0 ){
        printf("List Error: insertBefore() called on undefined cursor position");
        exit(1);
    }

    Node N = newNode(data);
    if( L->cursor==L->front ){
        L->cursor->prev = N;
        N->next = L->cursor;
        L->front = N;
    }else {
        L->cursor->prev->next = N;
        L->cursor->prev = N;
        N->prev = L->cursor->prev;
        N->next = L->cursor;
    }
    L->index++;
    L->length++;
}

// Inserts new element after cursor.
// Pre: length()>0, index()>=0
void insertAfter(List L, int data){
    if( L==NULL ){
        printf("List Error: insertAfter() called on NULL List reference");
        exit(1);
    }
    if( L->length<=0 ){
        printf("List Error: insertAfter() called on empty List");
        exit(1);
    }
    if( L->index<0 ){
        printf("List Error: insertAfter() called on undefined cursor position");
        exit(1);
    }

    Node N = newNode(data);
    if( L->cursor==L->back ){
        L->cursor->next = N;
        N->prev = L->cursor;
        L->back = N;
    }else {
        L->cursor->next->prev = N;
        N->next = L->cursor->next;
        L->cursor->next = N;
        N->prev = L->cursor;
    }
    L->length++;
}

// Deletes the front element.
// Pre: length()>0
void deleteFront(List L){
    if( L==NULL ){
        printf("List Error: deleteFront() called on NULL List reference");
        exit(1);
    }
    if( L->length<=0 ){
        printf("List Error: deleteFront() called on empty List");
        exit(1);
    }
    Node N = L->front;
    if( L->length>1 ){
        L->front = L->front->next;
    }else{
        L->front = L->back = NULL;
    }
    freeNode(&N);
    L->index--;
    L->length--;
}

// Deletes the back element.
// Pre: length()>0
void deleteBack(List L){
    if( L==NULL ){
        printf("List Error: deleteBack() called on NULL List reference");
        exit(1);
    }
    if( L->length<=0 ){
        printf("List Error: deleteBack() called on empty List");
        exit(1);
    }
    if( L->cursor==L->back ){
        L->cursor = L->cursor->prev;
        L->index--;
    }
    Node N = L->back;
    L->back = L->back->prev;
    L->back->next = NULL;
    freeNode(&N);
    L->length--;
}

// Deletes cursor element, making cursor undefined.
// Pre: length()>0, index()>=0
void delete(List L){
    if( L==NULL ){
        printf("List Error: delete() called on NULL List reference");
        exit(1);
    }
    if( L->length<=0 ){
        printf("List Error: delete() called on empty List");
        exit(1);
    }
    if( L->index<0 ){
        printf("List Error: delete() called on invalid cursor position");
        exit(1);
    }
    if( L->cursor==L->front ){
        Node N = L->cursor;
        L->front = L->front->next;
        L->front->prev = NULL;
        L->cursor = NULL;
        freeNode(&N);
    }
    if( L->cursor==L->back ){
        Node M = L->cursor;
        L->back = L->back->prev;
        L->back->next = NULL;
        L->cursor = NULL;
        freeNode(&M);
    }
    Node O = L->cursor;
    L->cursor->prev->next = L->cursor->next;
    L->cursor->next->prev = L->cursor->prev;
    L->cursor = NULL;
    freeNode(&O);

    L->index = -1;
    L->length--;
}

// ---------------------------
// Other Operations
// ---------------------------

void printList(FILE* out, List L){
//void printList(List L)
    Node N = NULL;

    if( L==NULL ){
        printf("List Error: printList() called on NULL List reference\n");
        exit(1);
    }

    for(N = L->front; N != NULL; N = N->next){
        printf("%d ", N->data);
    }
}

// Returns a new List representing the same integer sequence as this
// List. The cursor in the new list is undefined, regardless of the
// state of the cursor in this List. This List is unchanged.
// Pre: none
List copyList(List L){
    List listCopy = newList();
    Node N = L->front;

    while( N!=NULL ){
        append(listCopy, N->data);
        N = N->next;
    }
    return(listCopy);
}
