//Diraph.h
#ifndef DIRAPH_H

#include <vector>
#include <list>

template <int N, bool Dense>
class Diraph;

template <int N>
class Diraph<N, true> {
public:
    Diraph() : adjacency(N, std::vector<bool>(N, false)) {}

    void addEdge(int from, int to) {
        adjacency[from][to] = true;
    }

    bool isAdjacent(int from, int to) const {
        return adjacency[from][to];
    }

private:
    std::vector<std::vector<bool>> adjacency;
};


template <int N>
class Diraph<N, false> {
public:
    Diraph() : adjacency(N) {}

    void addEdge(int from, int to) {
        adjacency[from].push_back(to);
    }

    bool isAdjacent(int from, int to) const {
        for (int adj : adjacency[from]) {
            if (adj == to) {
                return true;
            }
        }
        return false;
    }

private:
    std::vector<std::list<int>> adjacency;
};

#endif // DIRAPH_H


