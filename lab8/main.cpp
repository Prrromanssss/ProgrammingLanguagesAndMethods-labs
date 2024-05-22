#include "Diraph.h"
#include <iostream>

int main() {
    Diraph<5, true> denseGraph;
    denseGraph.addEdge(0, 1);
    denseGraph.addEdge(1, 2);
    denseGraph.addEdge(2, 3);
    denseGraph.addEdge(0, 3);
    denseGraph.addEdge(0, 2);
    denseGraph.addEdge(3, 4);
    std::cout << "Dense Graph Adjacency Checking: " << denseGraph.isAdjacent(1, 2) << std::endl;
    std::cout << "Dense Graph Adjacency Checking: " << denseGraph.isAdjacent(1, 4) << std::endl;

    Diraph<5, false> sparseGraph;
    sparseGraph.addEdge(0, 1);
    sparseGraph.addEdge(0, 2);
    sparseGraph.addEdge(0, 3);
    std::cout << "Sparse Graph Adjacency Checking: " << sparseGraph.isAdjacent(0, 2) << std::endl;
    std::cout << "Sparse Graph Adjacency Checking: " << sparseGraph.isAdjacent(0, 4) << std::endl;
    std::cout << "Sparse Graph Adjacency Checking: " << sparseGraph.isAdjacent(0, 5) << std::endl;

    return 0;
}