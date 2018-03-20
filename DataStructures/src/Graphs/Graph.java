package Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int verticies;
    private LinkedList<Integer> neighbours[];

    Graph(int v)
    {
        verticies = v;
        neighbours = new LinkedList[v];
        for (int i=0; i<v; ++i)
            neighbours[i] = new LinkedList();
    }

    void addEdge(int v,int w)
    {
        neighbours[v].add(w);
    }

    void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> i = neighbours[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    private void DFS(int i){
        boolean visited[] = new boolean[verticies];

        DFSUtil(verticies, visited);

    }

    private void BFS(int i) {
        boolean visited[] = new boolean[verticies];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[i] = true;
        queue.add(i);

        while(!queue.isEmpty()){
            i = queue.poll();
            System.out.println(i);

            Iterator<Integer> itr = neighbours[i].listIterator();
            while (itr.hasNext())
            {
                int n = itr.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }


        }

    }

    public static void main(String args[]){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        g.BFS(2);
    }




}
