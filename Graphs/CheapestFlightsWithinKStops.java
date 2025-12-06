package Graphs;

import java.util.*;

public class CheapestFlightsWithinKStops {

    static class Edge {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Builds a directed graph (flights are usually directed)
    static void createGraph(int[][] flights, ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    // Info to store: node, cost so far, stops used
    static class Info implements Comparable<Info> {
        int node, dist, stops;

        public Info(int n, int d, int s) {
            this.node = n;
            this.dist = d;
            this.stops = s;
        }

        // Min-heap based on distance (cost)
        @Override
        public int compareTo(Info p2) {
            return this.dist - p2.dist;
        }
    }

    // Modified Dijkstra's Algorithm to handle at most k stops
    static int findCheapestFlightsWithinKStops(ArrayList<Edge>[] graph, int src, int dest, int k) {
        int n = graph.length;

        // dist[v] = current best (minimum) cost to reach v
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-heap based on total cost
        PriorityQueue<Info> pq = new PriorityQueue<>();
        // start with 0 cost and 0 stops used
        pq.add(new Info(src, 0, 0));

        while (!pq.isEmpty()) {
            Info curr = pq.poll();
            int u = curr.node;
            int costSoFar = curr.dist;
            int stopsSoFar = curr.stops;

            // If we reached destination, this is the cheapest within allowed stops
            if (u == dest) {
                return costSoFar;
            }

            // If we already used more than k stops, we cannot continue
            if (stopsSoFar > k) {
                continue;
            }

            // Relax adjacent edges
            for (Edge e : graph[u]) {
                int v = e.dest;
                int wt = e.wt;
                int newCost = costSoFar + wt;

                // If we found a cheaper cost to v within allowed stops, update
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.add(new Info(v, newCost, stopsSoFar + 1));
                }
            }
        }

        // If destination is not reachable within k stops
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0, dest = 3, k = 1;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int ans = findCheapestFlightsWithinKStops(graph, src, dest, k);
        System.out.println("Cheapest Price from " + src + " to " + dest + " within " + k + " stops = " + ans);
    }
}

/*
 * ---------------------------------------------------
 * NOTES:
 * • This solves Cheapest Flight within at most K stops using
 * a modified Dijkstra's algorithm with a priority queue.
 * • Info holds (node, totalCost, stopsUsed).
 * • We do NOT use a visited[] array because returning to a node
 * with fewer stops or cheaper cost can still give a better answer.
 * • We stop exploring a path when stopsUsed > k.
 * 
 * TIME COMPLEXITY:
 * • O(E log V)
 * (Each relaxation pushes into the priority queue)
 * 
 * SPACE COMPLEXITY:
 * • O(V + E)
 * (Adjacency list + dist[] + priority queue)
 * ---------------------------------------------------
 */
