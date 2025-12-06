package Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectingCities {
    static class Edge {
        int dest;
        int cost;

        public Edge(int d, int c) {
            this.dest = d;
            this.cost = c;
        }
    }

    // Prim's Algorithm - O(E.LogV)
    static int connectingCities(int cities[][]) {
        // Sorting cost in ascending order
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } };

        System.out.println("Minimum Cost for connecting all cities : " + connectingCities(cities));
    }
}
