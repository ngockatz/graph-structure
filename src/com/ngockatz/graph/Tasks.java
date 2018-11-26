package com.ngockatz.graph;

import java.util.*;

public class Tasks {
    private static final int UNVISITED = 0;
    private static final int VISITED = 1;
    private static final int INFINITY = Integer.MAX_VALUE;
    static int[] parent;

    static void printBFS(Graph G, int v) {
        for (int i = 0; i < G.noV(); i++)
            G.setFlag(i, UNVISITED);
        BFS(G, v);
    }

    static void BFS(Graph G, int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(v);
        G.setFlag(v, VISITED);
        while (!Q.isEmpty()) {
            v = Q.poll();
            System.out.print(v + " -> ");
            int[] nb = G.neighbors(v);
            for (int w : nb)
                if (G.getFlag(w) == UNVISITED) {
                    G.setFlag(w, VISITED);
                    Q.add(w);
                }
        }
    }

    static void printDFS(Graph G, int v) {
        for (int i = 0; i < G.noV(); i++)
            G.setFlag(i, UNVISITED);
        DFS(G, v);
    }

    static void DFS(Graph G, int v) {
        System.out.print(v + " -> ");
        G.setFlag(v, VISITED);
        int[] neighbors = G.neighbors(v);
        for (int neighbor : neighbors) {
            if (G.getFlag(neighbor) == UNVISITED)
                DFS(G, neighbor);
        }
    }

    /**
     * Compute shortest distances from a node to every other node
     *
     * @param s Start vertex
     * @param D Array storing distances
     */
    static void Dijkstra(Graph G, int s, int o, int[] D) {
        for (int i = 0; i < G.noV(); i++) {
            D[i] = INFINITY;  // Initialize distance
            G.setFlag(i,UNVISITED);
        }
        D[s] = 0;  // s to s is 0

        //Process all vertices in order of distance from s
        for (int i = 0; i < G.noV(); i++) {
            // next closest vertex
            int v = minVertex(G, D);
            if (v==o) break;
            G.setFlag(v, VISITED);
            if (D[v] == INFINITY) return; // Unreachable
            int[] nb = G.neighbors(v);
            // Process v's neighbors
            for (int w : nb) {
                if (D[w] > D[v] + G.weight(v, w)) {
                    D[w] = D[v] + G.weight(v, w);
                }
            }
        }
    }

    private static int minVertex(Graph G, int[] D) {
        int v = 0;
        // v is any unvisited vertex
        for (int i = 0; i < G.noV(); i++)
            if (G.getFlag(i) == UNVISITED) {
                v = i;
                break;
            }
        // now choose one with minimum distance
        for (int i = 0; i < G.noV(); i++)
            if (G.getFlag(i) == UNVISITED && D[i] < D[v])
                v = i;

        return v;
    }

    static void DijkstraPQ(Graph G, int s, int[] D) {
        // the current vertex
        parent = new int[G.noV()];
        int v;
        //DijPair[] E = new DijPair[G.noV()];
        //E[0] = new DijPair(0, s);  //initial vertex
        PriorityQueue<DijPair> PQ = new PriorityQueue<>(G.noE());
        //PQ.add(E[0]);
        PQ.add(new DijPair(0,s));
        // Initialize distance
        for (int i = 0; i < G.noV(); i++) {
            D[i] = INFINITY;
            G.setFlag(i,UNVISITED);
        }
        D[s] = 0;
        parent[s] = -1;
        // process all vertices
        for (int i = 0; i < G.noV(); i++) {
            // find unvisited vertex with minimum distance from s
            do {
                DijPair temp = PQ.poll();
                if (temp == null) return;
                v = temp.vertex();
            } while (G.getFlag(v) == VISITED);
            G.setFlag(v, VISITED);
            if (D[v] == INFINITY) return;  // unreachable
            int[] nb = G.neighbors(v);
            for (int w : nb) {
                if (D[w] > D[v] + G.weight(v, w)) {
                    D[w] = D[v] + G.weight(v, w);
                    parent[w] = v;
                    // update heap record
                    PQ.add(new DijPair(D[w], w));
                }
            }
        }

    }
    static void printPathBetween(Graph G, int s, int d){
        System.out.print(s + " -> ");
        printPath(G, s, d);
    }
    static void printPath(Graph G, int s, int d){
        if(parent[d] == -1 ) return;
        printPath(G, s, parent[d]);
        System.out.print(d + " -> ");
    }
}
