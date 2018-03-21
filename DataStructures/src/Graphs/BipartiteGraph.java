package Graphs;

//This can be solved using BFS, each "level" of the BFS tree
// needs to be on a different "stack"

import java.util.LinkedList;

public class BipartiteGraph {

    final static int V = 4;

    public boolean isBipartite(int G[][], int src){

        int colorArr[] = new int[V];
        for(int i = 0; i < V; ++i){
            colorArr[i] = -1;
        }

        colorArr[src] = 1;

        LinkedList<Integer> q = new LinkedList<Integer>();
        q.add(src);

        while(q.size() != 0){
            int node = q.poll();

            if(G[node][node] == 1){
                return false;
            }

            for(int i = 0; i < V; i++){
                if(G[node][i] == 1 && colorArr[i] == -1){
                    colorArr[i] = 1-colorArr[node];
                    q.add(i);
                }else if(G[node][i] == 1 && colorArr[i] == colorArr[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main (String[] args)
    {
        int G[][] =
               {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};

        BipartiteGraph b = new BipartiteGraph();
        if (b.isBipartite(G, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
