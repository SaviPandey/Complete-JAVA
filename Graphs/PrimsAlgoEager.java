package Graphs;

import java.util.*;

public class PrimsAlgoEager {

    // Edge class represents a weighted edge in the graph
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Builds an undirected weighted graph using adjacency list
    static void createGraph(ArrayList<Edge> graph[]) {
        // Initialize empty list for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (undirected graph => add both directions)
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    /*
     * Pair class is used inside PriorityQueue
     * v → vertex
     * cost → minimum cost to connect this vertex to MST
     */
    static class Pair {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    // Prim's Algorithm using Priority Queue (Eager approach)
    static void primsMst(ArrayList<Edge>[] graph) {

        int V = graph.length;

        // Visited array to mark vertices included in MST
        boolean[] vis = new boolean[V];

        // key[v] stores minimum weight edge connecting v to MST
        int[] key = new int[V];

        // parent[v] stores vertex that connects v to MST
        int[] parent = new int[V];

        // Initialize keys with infinite value
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Min-heap based on minimum cost (key value)
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));

        // Start from vertex 0
        key[0] = 0;
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.v;

            if (vis[u])
                continue;

            // Include vertex in MST
            vis[u] = true;

            // Relax adjacent edges
            for (Edge e : graph[u]) {
                int v = e.dest;

                // Update key and parent if a cheaper edge is found
                if (!vis[v] && e.wt < key[v]) {
                    key[v] = e.wt;
                    parent[v] = u;
                    pq.add(new Pair(v, key[v]));
                }
            }
        }

        // Print MST edges and calculate total cost
        int mstCost = 0;
        System.out.println("Edges in MST:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " (weight " + key[i] + ")");
            mstCost += key[i];
        }

        System.out.println("Total MST Cost = " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4;

        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        primsMst(graph);
    }
}

/*
 * ---------------------------------------------------
 * NOTES:
 * • This is Prim's Algorithm using a Priority Queue
 * • Uses Eager approach (best edge to each vertex is updated)
 * • Each vertex maintains a minimum connecting edge (key[])
 * • Parent array is used to reconstruct MST edges
 * • Graph must be connected to generate full MST
 * 
 * TIME COMPLEXITY:
 * • O(E log V)
 * (Each edge relaxation may update the priority queue)
 * 
 * SPACE COMPLEXITY:
 * • O(V + E)
 * (Adjacency list, PQ, key[], parent[], and visited[])
 * ---------------------------------------------------
 */
