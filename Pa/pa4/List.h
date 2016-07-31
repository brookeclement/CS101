//---------------------------------------------------------------
// List.h
// Christopher S. Gradwohl
// cgradwoh
// pa4
// header file for the ListADT
//---------------------------------------------------------------

#ifndef _LIST_H_INCLUDE_
#define _LIST_H_INCLUDE_

#include <stdio.h>

// Exported type
typedef struct ListObj* List;

// ----------------------------
// Constructors - Destructors
// ----------------------------

// public newList()
// returns new empty List object
List newList(void);

// public freeList()
// frees the heap memory pointed to by *pL, then sets *pL to NULL
void freeList(List* pL);

// ----------------------------
// Access functions
// ----------------------------

// Returns the number of elements in this List.
// Pre: none
int length(List L);

// If cursor is defined, returns the index of the cursor element,
// otherwise returns -1.
// Pre: none
int getindex(List L);

// Returns front element.
// Pre: length()>0
int front(List L);

// Returns back element.
// Pre: length()>0
int back(List L);

// Returns cursor element.
// Pre: length()>0, index()>=0
int get(List L);

// Returns true (1) if List A and B are the same integer
// sequence and returns false (0) otherwise.
// Pre: none
int equals(List A, List B);

// ----------------------------
// Manipulation Procedures
// ----------------------------

// Resets this List to its original empty state.
// Pre: none
void clear(List L);

// If List is non-empty, places the cursor under the front element,
// otherwise does nothing.
// Pre: none
void moveFront(List L);

// If List is non-empty, places the cursor under the back element,
// otherwise does nothing.
// Pre: none
void moveBack(List L);

// If cursor is defined and not at front, moves cursor one step toward
// front of this List, if cursor is defined and at front, cursor becomes
// undefined, if cursor is undefined does nothing.
// Pre: none
void movePrev(List L);

// If cursor is defined and not at back, moves cursor one step toward
// back of this List, if cursor is defined and at back, cursor becomes
// undefined, if cursor is undefined does nothing.
// Pre: none
void moveNext(List L);

// Insert new element into this List. If List is non-empty,
// insertion takes place before front element.
// Pre: none
void prepend(List L, int data);

// Insert new element into this List. If List is non-empty,
// insertion takes place after back element.
// Pre: none
void append(List L, int data);

// Insert new element before cursor.
// Pre: length()>0, index()>=0
void insertBefore(List L, int data);

// Inserts new element after cursor.
// Pre: length()>0, index()>=0
void insertAfter(List L, int data);

// Deletes the front element.
// Pre: length()>0
void deleteFront(List L);

// Deletes the back element.
// Pre: length()>0
void deleteBack(List L);

// Deletes cursor element, making cursor undefined.
// Pre: length()>0, index()>=0
void delete(List L);

// ----------------------------
// Other Functions
// ----------------------------

// prints list L to specified destination
// Pre: none
void printList(FILE* out, List L);

// Returns a new List representing the same integer sequence as this
// List. The cursor in the new list is undefined, regardless of the
// state of the cursor in this List. This List is unchanged.
// Pre: none
List copyList(List L);

#endif
