//---------------------------------------------------------------
// Graph.h
// Christopher S. Gradwohl
// cgradwoh
// pa4
// header file for the GraphADT
//---------------------------------------------------------------


#ifndef _GRAPH_H_INCLUDE_
#define _GRAPH_H_INCLUDE_

#include <stdio.h>
#include "List.h"
#define INF -999
#define NIL -998


// Exported type
typedef struct GraphObj* Graph;

// ---------------------------
// constructors - destructors
// ---------------------------
Graph newGraph(int n);
void freeGraph(Graph* pG);


// ---------------------------
// Access Functions
// ---------------------------
int getOrder(Graph G);
int getSize(Graph G);
int getSource(Graph G);
int getParent(Graph G, int u);
int getDist(Graph G, int u);
void getPath(List L, Graph G, int u);

// ---------------------------
// Manipulation Procedures
// ---------------------------
void makeNull(Graph G);
void addEdge(Graph G, int u, int v);
void addArc(Graph G, int u, int v);
void BFS(Graph G, int s);

// ---------------------------
// Other Operations
// ---------------------------
void printGraph(FILE* out, Graph G);


#endif
