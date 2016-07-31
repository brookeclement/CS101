//---------------------------------------------------------------
// Graph.c
// Christopher S. Gradwohl
// cgradwoh
// pa4
// GraphADT for the FindPath.c client
//---------------------------------------------------------------

#include <stdlib.h>
#include <stdio.h>
#include "Graph.h"


#define WHITE 11111
#define BLACK 99999
#define GRAY  33333


// ---------------------------
// structs
// ---------------------------
typedef struct GraphObj{
    List* adj;
    int* color;
    int* pred;
    int* dist;
    int order;
    int size;
    int source;
} GraphObj;


// ---------------------------
// constructors - destructors
// ---------------------------
Graph newGraph(int n){

    Graph G   = malloc(sizeof(GraphObj));
    G->adj    = calloc(n+1, sizeof(List));
    G->color  = calloc(n+1, sizeof(int));
    G->pred   = calloc(n+1, sizeof(int));
    G->dist   = calloc(n+1, sizeof(int));
    G->order  = n;
    G->size   = 0;
    G->source = NIL;

    for (int i=1; i<=n; i++) {
        G->adj[i] = newList();
        G->color[i] = WHITE;
		G->pred[i] = NIL;
		G->dist[i] = INF;
    }

    return (G);
}

void freeGraph(Graph* pG){
    Graph G = *pG;
    int i;

    for( i=1; i<=getOrder(G); i++ ){
        free(G->adj);
        free(G->color);
        free(G->pred);
        free(G->dist);
        free(*pG);
        *pG = NULL;
    }
}


// ---------------------------
// Access Functions
// ---------------------------
int getOrder(Graph G){
    if( G==NULL ){
        printf("Graph Error: cannot call getOrder() on NULL graph pointer");
        exit(1);
    }
    return G->order;
}


int getSize(Graph G){
    if( G==NULL ){
        printf("Graph Error: cannot call getSize() on NULL graph pointer");
        exit(1);
    }
    return G->size;
}


int getSource(Graph G){
    if( G==NULL ){
        printf("Graph Error: cannot call getSource() on NULL graph pointer");
        exit(1);
    }
    return G->source;
}


int getParent(Graph G, int u){
    if( G==NULL ){
        printf("Graph Error: cannot call getParent() on Null graph pointer");
        exit(1);
    }
    if( 1>u || u>getOrder(G) ){
        printf("Graph Error: vertex u is not in |V(G)|");
        exit(1);
    }
    return G->pred[u];
}

int getDist(Graph G, int u){
    if( G==NULL ){
        printf("Graph Error: cannot call getDist() on Null graph pointer");
        exit(1);
    }
    if( 1>u || u>getOrder(G) ){
        printf("Graph Error: vertex u is not in |V(G)|");
        exit(1);
    }
    return G->dist[u];
}

void getPath(List L, Graph G, int u){
    if (getSource(G) == NIL) {
		printf("Graph Error: must call BFS() before calling getPath()");
		exit (1);
	}
    if (G->source == u) {
		append(L, u);
	} else if (G->pred[u] != NIL) {
		getPath(L, G, G->pred[u]);
		append(L,u);
	}
}


// ---------------------------
// Manipulation Procedures
// ---------------------------


void makeNull(Graph G){
    int i;
    for( i=1; i<=getOrder(G); i++){
        clear(G->adj[i]);
    }
    G->size = 0;
}


// private helper function for addEdge()
// inserts vertex by vertex label sorted order
static void insertVertex(List L, int x){
    if( L==NULL ){
        printf("Graph Error: cannot insert vertex into NULL referenced List");
        exit(1);
    }

    moveFront(L);
    while( getindex(L)!=-1 ){
        int temp = get(L);
        if( temp<x ) moveNext(L);
        else {
            insertBefore(L, x);
            break;
        }
    }
    if( getindex(L)==-1 ) append(L, x);
}

// inserts a new edge joining u to v
// pre: 1<=u<=getOrder(), 1<=v<=getOrder()
void addEdge(Graph G, int u, int v){
    if( 1>u || u>getOrder(G) ){
        printf("Graph Error: vertex u is not in |V(G)|");
        exit(1);
    }
    if( 1>v || v>getOrder(G) ){
        printf("Graph Error: vertex v is not in |V(G)|");
        exit(1);
    }

    insertVertex(G->adj[u], v);
    insertVertex(G->adj[v], u);
    G->size++;
}


void addArc(Graph G, int u, int v){
    if( 1>u || u>getOrder(G) ){
        printf("Graph Error: vertex u is not in |V(G)|");
        exit(1);
    }
    if( 1>v || v>getOrder(G) ){
        printf("Graph Error: vertex v is not in |V(G)|");
        exit(1);
    }

    insertVertex(G->adj[u], v);
    G->size++;
}

void BFS(Graph G, int s){
    if( G==NULL ){
        printf("Graph Error: cannot run BFS() on NULL Graph pointer");
        exit(1);
    }
    if( 1>s || s>getOrder(G) ){
        printf("Graph Error: vertex s is not in |V(G)|");
        exit(1);
    }

    G->source = s;
    int i, x, y;
    for( i=1; i<=getOrder(G); i++){
        G->color[i] = WHITE;
        G->dist[i]  = INF;
        G->pred[i]  = NIL;
    }
    G->color[s] = GRAY;
    G->dist[s]  = 0;
    G->pred[s]  = NIL;
    List Q      = newList();


    append(Q, s);
    moveFront(Q);

    while( getindex(Q)!=-1 ){

        x = get(Q);
        moveFront(G->adj[x]);

        while( getindex(G->adj[x])!=-1 ){

            y = get(G->adj[x]);
            if( G->color[y]==WHITE ){
                G->color[y] = GRAY;
                G->dist[y]  = G->dist[x] + 1;
                G->pred[y]  = x;
                append(Q, y);
            }
            moveNext(G->adj[x]);
        }

        G->color[x] = BLACK;
        moveNext(Q);
    }
    freeList(&Q);
}






// ---------------------------
// Other Operations
// ---------------------------
void printGraph(FILE* out, Graph G){
    if( out == NULL ){
        printf("Graph Error: cannot print to NULL file pointer");
        return;
    }
    if( G == NULL ){
        printf("Graph Error: cannot print NULL Graph pointer");
        return;
    }

    for( int i=1; i<=getOrder(G); i++ ){
        fprintf(out, "%d: ", i);
        printList(out, G->adj[i]);
        fprintf(out, "\n");
    }
}
