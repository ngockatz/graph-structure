package com.ngockatz.graph;

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
        Tasks.printBFS(G,0);
        System.out.println("-------L below--------");

        GraphL GL = new GraphL(7);
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
        Tasks.printPathBetween(G,0,5);

        GraphL G4 = new GraphL(4);
        G4.setEdge(0, 1, 10);
        G4.setEdge(1, 2, 3);
        G4.setEdge(0, 2, 20);
        G4.setEdge(2, 3, 15);
        G4.setEdge(0, 3, 20);
        int[] Dz = new int[G4.noV()];
        int[] P = new int[G4.noV()];
        Tasks.Prim(G4, 0, Dz, P);
        System.out.println("Prim: " + Arrays.toString(P));
        for (int k = 1; k < P.length; k++) {
            System.out.print(P[k] + " -> " + k + " -> ");
        }
    }
}
