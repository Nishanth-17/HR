package com.forecast;
import java.io.*;
import java.util.*;

class Graph {
    static class Vertex {
        String dimension;
        int vertex_id;

        public String getDimension() {
            return dimension;
        }

        public void setDimension(String dimension) {
            this.dimension = dimension;
        }

        public int getVertex_id() {
            return vertex_id;
        }

        public void setVertex_id(int vertex_id) {
            this.vertex_id = vertex_id;
        }

        public Vertex(String dimension, int vertex_id) {
            this.dimension = dimension;
            this.vertex_id = vertex_id;
        }
    }
    // No. of vertices
    private int v;

    private ArrayList<ArrayList<Vertex> > adj;

    Graph(int v)
    {
        this.v = v;
        adj = new ArrayList<ArrayList<Vertex>>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Vertex>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, Vertex vertex) { adj.get(v).add(vertex); }

    List<Vertex> getAdjacentVertices(int index){
        return  adj.get(index);
    }

    // A recursive function used by topologicalSort
    int[] topologicalSortUtil(int v, boolean visited[],
                             Stack<Integer> stack, int level[], int currentLevel)
    {
        // Mark the current node as visited.
        visited[v] = true;
        currentLevel++;
        level[v] = currentLevel;
        Integer i;

        // Recur for all the vertices adjacent
        // to thisvertex
        Iterator<Vertex> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next().vertex_id;
            if (!visited[i]){
                level=topologicalSortUtil(i, visited, stack, level, currentLevel);
            }
        }

        // Push current vertex to stack
        // which stores result
        stack.push(new Integer(v));
        return level;
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    List<Integer> topologicalSort()
    {
        Stack<Integer> stack = new Stack<Integer>();
        List<Integer> sequence = new ArrayList<>();
        int level[] = new int[v];
        Arrays.fill(level,0);
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++)
            visited[i] = false;

        for (int i = 0; i < v; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack, level, 0);

        System.out.println(Arrays.toString(level));
        System.out.println("ac"+stack);
        return sequence;
    }

    // Driver code
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        Graph g = new Graph(11);
        g.addEdge(0, new Vertex("PAYROLL",1));
        g.addEdge(0,new Vertex("AP & BENEFITS",2));
        g.addEdge(2, new Vertex("CHILD1",3));
        g.addEdge(2, new Vertex("CHILD2",4));
        g.addEdge(2, new Vertex("CHILD3",5));
        g.addEdge(2, new Vertex("CHILD4",6));
        g.addEdge(2, new Vertex("CHILD5",7));
        g.addEdge(2, new Vertex("CHILD6",8));
        g.addEdge(2, new Vertex("CHILD7",9));
        g.addEdge(2, new Vertex("CHILD8",10));

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        List<Integer> sequence=g.topologicalSort();
        Collections.reverse(sequence);
        System.out.println(sequence);
        System.out.println();
        for(int i=0;i<11;i++){
            List<Vertex> vertices = g.getAdjacentVertices(i);
            System.out.print(i + "---> [");
            for(int j=0;j<vertices.size();j++){
                System.out.print(vertices.get(j).getDimension() + " - "+ vertices.get(j).getVertex_id()+",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}

