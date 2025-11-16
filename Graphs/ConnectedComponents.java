package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {
    static class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            this.src= s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // ---------- Component 1 (0,1,2) ----------
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        // ---------- Component 2 (3,4,5) ----------
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 4, 1));

        // ---------- Component 3 (6,7) ----------
        graph[6].add(new Edge(6, 7, 1));
        graph[7].add(new Edge(7, 6, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i < graph.length; i++){
            if(!vis[i]){
                // New component starts here
                bfsUtils(graph, vis, i);
                System.out.println(); // separate components
            }
            
        }
    }
    public static void bfsUtils(ArrayList<Edge>[] graph, boolean[] vis, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        vis[start] = true;

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");

            for (Edge e : graph[curr]) {
                if (!vis[e.dest]) {
                    vis[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i < graph.length; i++){
            if(!vis[i]){
                dfsUtils(graph, i,  vis);
                System.out.println(); 
            }
        }
    }
    public static void dfsUtils(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(Edge e: graph[curr]){
            if(!vis[e.dest]){
                dfsUtils(graph, e.dest, vis);
            }
        }
    }
    public static void main(String args[]){
        int V = 8   ;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        System.out.println("BFS Connected Components:");
        bfs(graph);

        System.out.println("DFS Connected Components:");
        dfs(graph);

    }
}
