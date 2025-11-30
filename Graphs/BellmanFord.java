package Graphs;

import java.util.ArrayList;

public class BellmanFord {

    // Edge class to store source, destination, and weight
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Adjacency-list based graph
    static void createGraph(ArrayList<Edge>[] graph) {
        // Initialize each adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    // Edge-list based graph
    static void createGraph2(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    // Bellman-Ford algorithm to find shortest paths from source
    static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];

        // Step 1: Initialize distances
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; // Distance from source to itself is 0

        // Step 2: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            // Traverse all vertices
            for (ArrayList<Edge> edges : graph) {

                // Traverse all edges of current vertex
                for (Edge e : edges) {
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation condition
                    /*
                     * Why we check: dist[u] != Integer.MAX_VALUE
                     *
                     * This condition ensures that the source vertex of the edge is reachable
                     * from the starting node before performing relaxation.
                     * If dist[u] were Integer.MAX_VALUE, adding the edge weight could cause
                     * integer overflow and lead to incorrect shortest-path updates.
                     * In Dijkstra’s algorithm, this check is implicit because only vertices
                     * with finite distances are processed using the priority queue.
                     */

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // Step 3: Print shortest distance from source to all vertices
        System.out.println("Source node: " + src);
        System.out.println("Shortest distances to all vertices:");

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(src + " -> " + i + " = INF");
            } else {
                System.out.println(src + " -> " + i + " = " + dist[i]);
            }
        }

        System.out.println("===============================");

        System.out.println("Vertex\tDistance");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + "\tINF");
            } else {
                System.out.println(i + "\t" + dist[i]);
            }
        }
    }

    // Bellman-Ford using EDGE LIST
    static void bellmanFord2(ArrayList<Edge> graph, int V, int src) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (Edge e : graph) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (Edge e : graph) {
            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }
        System.out.println("Source node: " + src);
        System.out.println("Shortest distances to all vertices:");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(src + " -> " + i + " = INF");
            } else {
                System.out.println(src + " -> " + i + " = " + dist[i]);
            }
        }
        System.out.println("===============================");
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int src = 0;

        @SuppressWarnings("unchecked")
        // ArrayList<Edge>[] graph = new ArrayList[V];
        // createGraph(graph);
        // bellmanFord(graph, src);

        ArrayList<Edge> graph = new ArrayList<>();
        createGraph2(graph);
        bellmanFord2(graph, V, src);
    }
}

/*
 * Time Complexity:
 * O(V * E)
 * - The algorithm relaxes all edges (E) exactly (V - 1) times.
 *
 * Space Complexity:
 * O(V)
 * - A distance array of size V is used to store shortest distances.
 * - Graph is stored using adjacency list which takes O(V + E) space.
 */
