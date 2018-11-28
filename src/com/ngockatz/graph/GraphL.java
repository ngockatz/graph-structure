package com.ngockatz.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphL implements Graph {
    private Edge[] nodeArr; //vertex list
    private int[] Flags;    //to help with traversal
    private int noEdge;     //number of edges

    GraphL(){}
    GraphL(int n){init(n);}

    public void init(int n) {
        nodeArr = new Edge[n];
        //Initialize header for each vertex
        for(int i=0; i<n; i++){
            nodeArr[i] = new Edge(-1,-1,null);
        }
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

    /** Return the node in v's neighbor list that proceeds node w*/
    private Edge find(int v, int w){
        Edge curr = nodeArr[v];
        while (curr.next!=null && curr.next.vertex < w)
            curr=curr.next;
        return curr;
    }
    public void setEdge(int v, int w, int wgt) {
        assert wgt > 0:"Weight cannot be negative or zero";
        Edge curr=find(v,w);
        if(curr.next!=null && curr.next.vertex==w){
            //if already exist update edge but no increment
            if (curr.next.weight > 0) noEdge++;
            curr.next.weight=wgt;
        }
        else {
            //create new node when not exist
            curr.next = new Edge(w,wgt,curr.next);
            noEdge++;
        }
    }

    public int weight(int v, int w) {
        Edge curr = find(v,w);
        if(curr.next==null || curr.next.vertex!=w) return 0;
        return curr.next.weight;
    }

    public void delEdge(int v, int w) {
        Edge curr = find(v,w);
        if(curr.next==null || curr.next.vertex!=w) return;
        else {
            curr.next=curr.next.next;
            noEdge--;
        }
    }

    public boolean hasEdge(int v, int w) {
        return weight(v,w) > 0;
    }

    public int[] neighbors(int v) {
        int cnt=0;
        Edge curr;
        for(curr=nodeArr[v].next;curr!=null;curr=curr.next){
            cnt++;
        }
        int neighbors[] = new int[cnt];
        for(curr=nodeArr[v].next,cnt=0;curr!=null;curr=curr.next){
            neighbors[cnt++] = curr.vertex;
        }
        return neighbors;
    }

}
