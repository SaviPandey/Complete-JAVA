package Graphs;

import java.util.*;

public class KruskalAlgo {
    static class Edge implements Comparable<Edge> {
        int src, dest, wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4; // Vertices
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (par[x] != x)
            par[x] = find(x);
        return par[x];
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0; // number of edges added in the MST

        // Loop runs while:
        // 1) i < edges.size() → prevents going out of bounds when scanning sorted edges
        // 2) count < V - 1 → MST needs exactly V-1 edges, so stop once done
        // In short: stop early when MST is complete, and avoid index overflow.
        for (int i = 0; i < edges.size() && count < V - 1; i++) {
            Edge e = edges.get(i); // (src, dest, wt)

            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                mstCost += e.wt;
                union(e.src, e.dest);
                count++;
            }
        }
        System.out.println("COST OF MST: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges, V);
    }
}

/*
 * ------------------------------------------------------------
 * Time & Space Complexity of Kruskal's Algorithm
 * ------------------------------------------------------------
 * 
 * Time Complexity:
 * 1. Sorting all edges: O(E log E)
 * 2. Union-Find operations: O(E α(V)) ≈ O(E)
 * Total: O(E log E) ≈ O(E log V)
 * 
 * Space Complexity:
 * - Parent[] + Rank[] arrays: O(V)
 * - Edge list: O(E)
 * Total: O(V + E)
 * 
 * Comparison with Prim's Algorithm:
 * ------------------------------------------------------------
 * Kruskal:
 * - Better for sparse graphs (fewer edges)
 * - Works naturally with edge lists
 * - Uses sorting + Union-Find
 * 
 * Prim:
 * - With Min-Heap: O(E log V)
 * - Better for dense graphs (many edges)
 * - Grows MST from a starting vertex
 * 
 * Overall:
 * - Kruskal is edge-based and builds a forest.
 * - Prim is vertex-based and grows a single tree.
 * ------------------------------------------------------------
 */
