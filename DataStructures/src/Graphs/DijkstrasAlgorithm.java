package Graphs;

/**
 * Created by shivangipatwardhan on 3/20/18.
 */
public class DijkstrasAlgorithm {

    static final int V=9;
    // Single Source shortest path
    private void dijkstra(int[][] graph, int src) {

        int dist[] = new int[V];

        Boolean spanningSet[] = new Boolean[V];

        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            spanningSet[i] = false;
        }

        dist[src] = 0;

        // Find shortest path for across all the verticies
        for(int count = 0; count < V - 1; count++){

            //Pick the minimum distance so far
            int u = minimumDistance(dist, spanningSet);

            spanningSet[u] = true;

            for(int v = 0; v < V; v++){

                if(!spanningSet[v] &&
                        graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                }

            }
        }

    }

    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" tt "+dist[i]);
    }

    private int minimumDistance(int[] dist, Boolean[] spanningSet) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for(int v = 0; v < V; v++){
            if(spanningSet[v] == false && dist[v] <= min){
                min = dist[V];
                min_index = v;
            }
        }
        return min_index;
    }

    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        DijkstrasAlgorithm t = new DijkstrasAlgorithm();
        t.dijkstra(graph, 0);
    }

}





