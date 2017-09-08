/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author Mehak Beri
 */
public class Assign4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        adjacencyList graph1= new adjacencyList(10);
        graph1.addEdge(1,2);
        graph1.addEdge(1, 4);
        graph1.addEdge(4,5);
        graph1.addEdge(4, 8);
        graph1.addEdge(8,9);
        graph1.addEdge(9,8);
        graph1.addEdge(9,5);
        graph1.addEdge(5, 2);
        graph1.addEdge(5,6);
        graph1.addEdge(2, 3);
        graph1.addEdge(2,10);
        graph1.addEdge(10, 9);
        graph1.addEdge(6, 7);
        graph1.addEdge(7, 3);
        graph1.addEdge(7, 10);
        graph1.printAdjList();
        graph1.BFStraversal(1); //start bfs traversal at node 1
        graph1.DFStraversal(1); //start dfs traversal at node 1
    }
    
}
//initialize a graph using adjacency list
@SuppressWarnings("unchecked")
class adjacencyList{
    private int size; //number of nodes, and size of array
    private List<Integer>[] adj; //array containing list<string> as each element
    public adjacencyList()
    {
        this(10); //initialize a graph with 10 nodes if nothing given
    }
    public adjacencyList(int k)
    {
        size=k;
        adj = (List<Integer>[])new List[size];
        for(int i=0; i<size;i++)
        {
            adj[i]= new ArrayList<>();
        }
        System.out.println("Graph initialized with "+k+" nodes!");
    }
    public void addEdge(int startvertex, int endvertex)
    {
        int start= startvertex-1;
        int end= endvertex-1;
        adj[start].add(end);
        

    }
    public int NumNodes()
    {
        return size;
    }
    public void printAdjList()
    {
        for(int i=0; i<size; i++)
        {
            System.out.print("Node "+(i+1)+ " : [ ");
            for(int k : adj[i])
            {
                System.out.print((k+1) + " ");
            }
            System.out.println("]\n");
        }
    }
    public void removeEdge(int startvertex, int endvertex)
    {
        adj[startvertex-1].remove(new Integer(endvertex-1));
    }
    
    public void BFStraversal(int start)
    {
        System.out.print("BFS traversal: ");
        boolean[] visited= new boolean[size]; //boolean array to keep track of visited nodes
        int[] arrQueue= new int[size];
        int m=0; //pointer to front of queue
        int j=0;
        for(int i=start-1; i<size; i++)
        {
            if(visited[i]==false)
            {
                arrQueue[m]=i;
                System.out.print((i+1)+" ");
                visited[i]=true;
                m++;
                while(j<size){
                for(int k: adj[arrQueue[j]])
                {
                    if(visited[k]==false)
                    {
                    arrQueue[m]= k; 
                    System.out.print((k+1)+" ");
                    visited[k]=true;
                    m++;
                    }
                }
                j++;
                }
            }
        }
        System.out.print("\n");
    }
    
    public void DFStraversal(int start)
    {
        System.out.print("DFS traversal:");
        boolean[] visit= new boolean[size]; //boolean array to keep track of visited nodes
        for(int s=start; s<size+1; s++)
        {
            if(visit[s-1]==false)
            {
                DFS(s,visit);
            }
        }
        
    }

    public void DFS(int start, boolean[] visited)
    {   
        if(visited[start-1]==true)
        {
            return;
        }
        visited[start-1]=true; //start-1 because nodes are labelled starting from 1, not starting from zero
        System.out.print(start+" ");
        for(int k: adj[start-1])
        {
            if(visited[k]!=true)
            {
                DFS(k+1,visited);
            }
        }
    }
}
