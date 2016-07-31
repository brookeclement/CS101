//---------------------------------------------------------------
// GraphTest.c
// Christopher S. Gradwohl
// cgradwoh
// pa4
// Test client for the GraphADT
//---------------------------------------------------------------

#include <stdlib.h>
#include <stdio.h>
#include "Graph.h"

int main(int argc, char const *argv[]) {
    Graph G = newGraph(6);

    printGraph(stdout, G);

    addEdge(G, 1, 2);
    addEdge(G, 1, 3);
    addEdge(G, 2, 4);
    addEdge(G, 2, 5);
    addEdge(G, 2, 6);
    addEdge(G, 3, 4);
    addEdge(G, 4, 5);
    addEdge(G, 5, 6);

    printGraph(stdout, G);
    printf("getOrder(): %i\n", getOrder(G));
    printf("getSize(): %i\n", getSize(G));
    printf("getSource(): %i\n", getSource(G));

    BFS(G, 1);

    printGraph(stdout, G);
    printf("getOrder()AFTER BFS: %i\n", getOrder(G));
    printf("getSize(): %i\n", getSize(G));
    printf("getSource(): %i\n", getSource(G));

    printf("getParent(G, 1): %i\n", getParent(G, 1));
    printf("getParent(G, 2): %i\n", getParent(G, 2));
    printf("getParent(G, 3): %i\n", getParent(G, 3));
    printf("getParent(G, 4): %i\n", getParent(G, 4));
    printf("getParent(G, 5): %i\n", getParent(G, 5));
    printf("getParent(G, 6): %i\n", getParent(G, 6));

    printf("getDist(G, 1): %i\n", getDist(G, 1));
    printf("getDist(G, 2): %i\n", getDist(G, 2));
    printf("getDist(G, 3): %i\n", getDist(G, 3));
    printf("getDist(G, 4): %i\n", getDist(G, 4));
    printf("getDist(G, 5): %i\n", getDist(G, 5));
    printf("getDist(G, 6): %i\n", getDist(G, 6));

    List path = newList();
    getPath(path, G, 5);
    printf("dist: 1 to 5 %i\n", getDist(G, 5));
    printList(stdout, path);
    printf("\n");

    BFS(G, 3);
    List path1 = newList();
    getPath(path1, G, 6);
    printf("dist: 3 to 6 %i\n", getDist(G, 6));
    printList(stdout, path1);
    printf("\n");

    BFS(G, 2);
    List path2 = newList();
    getPath(path2, G, 3);
    printf("dist: 2 to 3 %i\n", getDist(G, 3));
    printList(stdout, path2);
    printf("\n");

    BFS(G, 4);
    List path3 = newList();
    getPath(path3, G, 4);
    printf("dist: 4 to 4 %i\n", getDist(G, 4));
    printList(stdout, path3);
    printf("\n");

    makeNull(G);
    printGraph(stdout, G);



    return 0;
}
