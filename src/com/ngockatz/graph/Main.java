package com.ngockatz.graph;

import javafx.concurrent.Task;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    GraphM G = new GraphM(6);
	    G.setUndirectedEdge(0,2,7);
        G.setUndirectedEdge(0,4,9);
        G.setUndirectedEdge(2,3,1);
        G.setUndirectedEdge(2,1,5);
        G.setUndirectedEdge(1,5,6);
        G.setUndirectedEdge(3,5,2);
        G.setUndirectedEdge(2,5,2);
        Tasks.printDFS(G,0);
        System.out.println();
        Tasks.printBFS(G,0);
        System.out.println("-------L below--------");
        GraphL GL = new GraphL(6);
        GL.setEdge(0,2,7);
        GL.setEdge(0,4,9);
        GL.setEdge(2,3,1);
        GL.setEdge(2,1,5);
        GL.setEdge(1,5,6);
        GL.setEdge(3,5,2);
        GL.setEdge(2,5,2);
        Tasks.printBFS(G,0);
        int[] D = new int[GL.noV()];
        Tasks.DijkstraPQ(GL, 0, D);
        System.out.println(Arrays.toString(D));
        //System.out.println(Tasks.minDistance(G, 0, 5));
        Tasks.printPathBetween(G,0,5);
    }
}
