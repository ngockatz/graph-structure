package com.ngockatz.graph;

/**
 * <p>Single link node</p>
 * Data members:
 * <ul>
 *     <li>vertex: index of vertex pointed to by edge</li>
 *     <li>weight: weight of this node/edge</li>
 *     <li>next: address of next node</li>
 * </ul>
 */

public class Edge {
    int vertex;
    int weight;
    Edge next;

    Edge(int v, int w, Edge n) {
        vertex = v;
        weight = w;
        next = n;
    }
}
