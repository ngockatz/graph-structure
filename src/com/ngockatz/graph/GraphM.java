package com.ngockatz.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphM implements Graph {

    private int[][] matrix; //graph info
    private int[] Flags; //to help with traversal
    private int noEdge; //number of edges
    private static final int UNVISITED=0;
    private static final int VISITED=1;
    GraphM(){}
    GraphM(int n){
        init(n);
    }

    public void init(int n) {
        matrix = new int[n][n];
        Flags = new int[n];
        noEdge = 0;
    }

    public int noV() {
        return Flags.length;
    }

    public int noE() {
        return noEdge;
    }

    public int getFlag(int v) {
        return Flags[v];
    }

    public void setFlag(int v, int val) {
        Flags[v] = val;
    }

    public void setEdge(int v, int w, int wgt) {
        assert wgt>0: "Weight cannot be 0 or negative";
        if (matrix[v][w]==0) noEdge++;
        matrix[v][w] = wgt;
    }

    public void setUndirectedEdge(int v, int w, int wgt){
        assert wgt>0: "Weight cannot be 0 or negative";
        if (matrix[v][w]==0) noEdge++;
        matrix[v][w] = wgt;
        if (matrix[w][v]==0) noEdge++;
        matrix[w][v] = wgt;
    }

    public int weight(int v, int w) {
        return matrix[v][w];
    }

    public void delEdge(int v, int w) {
        matrix[v][w]=0;
        noEdge--;
    }

    public boolean hasEdge(int v, int w) {
        return matrix[v][w] > 0;
    }

    public int[] neighbors(int v) {
        int[] neighbors;
        int i;
        int count=0;
        //count the neighbors
        for(i=0; i<Flags.length;i++){
            if (matrix[v][i]>0) count++;
        }
        neighbors = new int[count];
        //put neighbors in
        for(i=0, count=0; i<Flags.length; i++){
            if (matrix[v][i] > 0) neighbors[count++]=i;
        }
        return neighbors;
    }
}
