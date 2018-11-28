package com.ngockatz.graph;

public interface Graph {
    /**Initialize the graph with some number of vertices
    */
    void init(int n);

    /**Return the number of vertices*/
    int noV();

    /**Return the current number of edges*/
    int noE();

    /**Get the flag of vertex with index v*/
    int getFlag(int v);

     /**Set the flag of vertex with index v*/
    void setFlag(int v, int val);

    /**Adds a new edge from node v to node w with weight wgt*/
    void setEdge(int v, int w, int wgt);

     /**Get the weight value for an edge*/
    int weight(int v, int w);

    /**Removes the edge from the graph*/
    void delEdge(int v, int w);

    /**Returns true iff the graph has the edge*/
    boolean hasEdge(int v, int w);

    /**
     * Returns an array containing the indices of the neighbors of v
     */
    int[] neighbors(int v);

}
