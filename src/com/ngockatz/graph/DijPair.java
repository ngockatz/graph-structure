package com.ngockatz.graph;

/** Dijkstra pair element for Priority Queue
 * <ul>
 *     <li>weight (key): weight/distance</li>
 *     <li>vertex: the vertex associated with the distance</li>
 * </ul>*/
public class DijPair implements Comparable<DijPair> {
    private int vertex;
    private int weight;

    public DijPair(int w, int v)
    { vertex = v; weight = w; }
    public DijPair() {vertex = 0; weight = 0; }

    public int key() { return weight; }
    public int vertex() { return vertex; }
    public int compareTo (DijPair that) {
        if (weight < that.key()) return -1;
        else if  (weight == that.key()) return 0;
        else return 1;
    }
}
