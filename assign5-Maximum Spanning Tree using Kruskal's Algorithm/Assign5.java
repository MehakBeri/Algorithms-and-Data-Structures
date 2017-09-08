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
public class Assign5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        adjacencyMatrix graph1= new adjacencyMatrix(10, 15);
        graph1.addEdge(0,1,10);
        graph1.addEdge(1,2,20);
        graph1.addEdge(2,6,30);
        graph1.addEdge(0,4,11);
        graph1.addEdge(4,2,12);
        graph1.addEdge(2,5,15);
        graph1.addEdge(3,4,45);
        graph1.addEdge(4,5,85);
        graph1.addEdge(5,6,33);
        graph1.addEdge(6,9,21);
        graph1.addEdge(5,8,26);
        graph1.addEdge(5,9,60);
        graph1.addEdge(3,7,93);
        graph1.addEdge(3,8,19);
        graph1.addEdge(7,8,57);
        graph1.printAdjMatrix();
        graph1.mstKruskal();
    }
}

class edge{
    private int startvertex;
    private int endvertex;
    private int weight;
    
    public edge(int s, int e, int w)
    {
        startvertex=s;
        endvertex=e;
        weight=w;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public int getStartVertex(){
       return startvertex;
    }
    
    public int getEndVertex(){
        return endvertex;
    }
}

class sortByWeight implements Comparator<edge>{
    @Override
    public int compare(edge e1, edge e2){
        return e1.getWeight()-e2.getWeight();
    }
}
class adjacencyMatrix{
    private int V; //number of vertices
    private int E; //number of edges
    private Integer[][] adj; //adjacency matrix
    private ArrayList<edge> graphEdge; //list of all edges in the graph
    public adjacencyMatrix()
    {
        this(10,15); //initialize a graph with 10 vertices and 15 edges if nothing given, starting from zero
    }
    public adjacencyMatrix(int v, int e)
    {
        V=v;
        E=e;
        adj= new Integer[v][v];
        graphEdge= new ArrayList<>();
        for(int i=0; i<v; i++)
        {
            for(int j=0; j<v; j++)
            {
                adj[i][j]=null;
            }
        }
        System.out.println("Weighted Graph initialized with "+v+" nodes and "+e+ " edges!");
    }
    public void addEdge(int vertex1, int vertex2, int weight)
    {
        //if adj[i][j]=null means no edge from i to j exists. value of adj[i][j] gives the value of the edge from i to j
        adj[vertex1][vertex2]=weight;   
        adj[vertex2][vertex1]=weight;
        graphEdge.add(new edge(vertex1, vertex2, weight));
    }
    public int NumVertices()
    {
        return V;
    }
    public int NumEdges()
    {
        return E;
    }
    public void printAdjMatrix()
    {
        System.out.println("Adjacency Matrix: ");
        for(int i=0; i<V; i++)
        {
            for (int j=0; j<V; j++)
            {
                System.out.printf("%7d",adj[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }
    public void mstKruskal(){
        //initialize each vertex as an independent cluster. here array list acts as a cluster
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for(int j=0; j<V; j++)
        {
            ArrayList<Integer> a = new ArrayList<>();
            l.add(a);
            l.get(j).add(j);
        }
        //sort the edges by their weight in ascending order
        Collections.sort(graphEdge, new sortByWeight());
        ArrayList<edge> mst= new ArrayList<>(); //this cluster will finally hold the edges in mst
        int i=0;
        while(i<graphEdge.size()){
            edge e= graphEdge.get(i); //one by one get minimum edge and check if vertices are there.
            int v1 = e.getStartVertex();
            int v2= e.getEndVertex();
            // l.get(v) is the cluster in which we will search whether the second vertex is there or not. 
            if (!(l.get(v1).contains(v2) || l.get(v2).contains(v1)))
            {//merge cluster of v1 and v2, add each element of cluster v2 to v1
                for(int k: l.get(v2))
                {
                    l.get(v1).add(k);
                }
                l.set(v2,l.get(v1)); //add v1 to cluster of v2 , cannot remove element from list or else indexes change
                //add edge to mst
                mst.add(e);
            }
            i++;
        }
        System.out.println("The MST using Kruskal's algorithm is given by the following edges:");
        int sum=0;
        System.out.println("[vertex1 , vertex2]-->edge weight");
        for(edge e: mst)
        {
            System.out.println("["+e.getStartVertex()+" , "+e.getEndVertex()+"] -->"+e.getWeight());
            sum=sum+e.getWeight();
        }
        System.out.println("Sum of weights of MST: "+sum);
    }
}
