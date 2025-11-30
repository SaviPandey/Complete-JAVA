package Graphs;

import java.util.*;

public class PrimsAlgoLazy {
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
     * v → vertex being considered
     * cost → edge weight to connect this vertex to MST
     * edge → actual edge used to reach this vertex
     */
    static class Pair {
        int v;
        int cost;
        Edge edge;

        public Pair(int vertex, int c, Edge e) {
            this.v = vertex;
            this.cost = c;
            this.edge = e;
        }
    }

    // Prim's Algorithm using Priority Queue (Lazy approach)
    static void primsMst(ArrayList<Edge>[] graph) {
        // Marks whether a vertex is already included in MST
        boolean[] vis = new boolean[graph.length];
        // Stores edges that are part of the MST
        ArrayList<Edge> mst = new ArrayList<>();

        // Min-heap based on edge weight
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        // Start from vertex 0 (cost = 0, no edge initially)
        pq.add(new Pair(0, 0, null));
        int mstCost = 0;

        // Process until all reachable vertices are included
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            // Skip if vertex is already visited
            if (vis[curr.v])
                continue;

            // Include vertex in MST
            vis[curr.v] = true;
            mstCost += curr.cost;

            // If edge exists, add it to MST edge list
            if (curr.edge != null) {
                mst.add(curr.edge);
            }

            // Add all adjacent edges to priority queue
            for (Edge e : graph[curr.v]) {
                if (!vis[e.dest]) {
                    pq.add(new Pair(e.dest, e.wt, e));
                }
            }
        }
        System.out.println("Edges in MST:");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " (weight " + e.wt + ")");
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
 * • Uses Lazy approach (multiple entries allowed in PQ)
 * • Graph must be connected to get full MST
 * • Priority Queue helps pick minimum weight edge first
 * 
 * TIME COMPLEXITY:
 * • O(E log V)
 * (Each edge can be inserted into the priority queue)
 * 
 * SPACE COMPLEXITY:
 * • O(V + E)
 * (Visited array, adjacency list, PQ, and MST list)
 * ---------------------------------------------------
 */
