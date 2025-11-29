package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgo {

    // Edge class represents a weighted directed edge in the graph
    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Create adjacency list representation of the graph
    static void createGraph(ArrayList<Edge> graph[]) {

        // Initialize empty ArrayList for each vertex
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (source, destination, weight)
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    // Pair class is used in PriorityQueue to store node and its distance
    static class Pair implements Comparable<Pair> {
        int n, dist;

        public Pair(int node, int distance) {
            this.n = node;
            this.dist = distance;
        }

        // Sort pairs based on minimum distance (min-heap behavior)
        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }

    // Dijkstra's Algorithm using Priority Queue
    public static void dijkstra(ArrayList<Edge> graph[], int src) {

        int dist[] = new int[graph.length];

        // Initialize distances of all vertices as infinity
        // Distance of source vertex is 0 by default
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        // Visited array to avoid reprocessing a node
        boolean vis[] = new boolean[graph.length];

        // Min-heap priority queue based on shortest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        // Main loop of Dijkstra's Algorithm
        while (!pq.isEmpty()) {

            // Get the node with minimum distance
            Pair curr = pq.remove();

            // Process node only if not visited
            if (!vis[curr.n]) {
                vis[curr.n] = true;

                // Relax all adjacent edges of the current node
                for (Edge e : graph[curr.n]) {

                    int u = e.src; // current node
                    int v = e.dest; // neighboring node
                    int wt = e.wt; // edge weight

                    // Relaxation condition
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        // Print shortest distance from source to all vertices
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
            System.out.println(i + "\t" + dist[i]);
        }

    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
}

/*
 * Dijkstra's Algorithm using Priority Queue
 *
 * Time Complexity:
 * O((V + E) log V)
 * - Each vertex can be inserted into the priority queue
 * - Each edge relaxation takes log V time
 *
 * Space Complexity:
 * O(V + E)
 * - Adjacency list stores E edges
 * - Distance array, visited array, and priority queue store up to V elements
 *
 * Note:
 * Works only for graphs with NON-negative edge weights
 */
