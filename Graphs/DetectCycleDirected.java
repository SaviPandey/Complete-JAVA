package Graphs;

import java.util.*;

public class DetectCycleDirected {

    public static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // public  static void createGraph(ArrayList<Edge>[] graph) {
    //     for(int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 2));
    //     graph[1].add(new Edge(1, 0));
    //     graph[2].add(new Edge(2, 3));
    //     graph[3].add(new Edge(3, 0)); //CYCLE : TRUE
    // }

    // GRAPH-2
    // public  static void createGraph(ArrayList<Edge>[] graph) {
    //     for(int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 1));
    //     graph[0].add(new Edge(0, 2));
        
    //     graph[1].add(new Edge(1, 3));

    //     graph[2].add(new Edge(2, 3)); //CYCLE : FALSE
    // }
    //GRAPH-3
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length]; 
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtils(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtils(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for (Edge e : graph[curr]) {
            if (stack[e.dest]) { // CYCLE FOUND
                return true;
            }

            if (!vis[e.dest] && isCycleUtils(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false; // remove from recursion stack
        return false;
    }

    public static void main(String args[]) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println("Cycle present in the Graph: "+isCycle(graph));  // Output: true
    }
}
  