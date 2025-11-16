package Graphs;
import java.util.ArrayList;

public class DetectCycle {
    public static class Edge{
        int src, dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){  // O(V + E)
        boolean vis[] = new boolean[graph.length];

        for(int i=0; i < graph.length; i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, -1)){
                    return true;    //Cycle exists in any one of the part
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par){
        vis[curr] = true;

        for(Edge e : graph[curr]){

            //Case-3
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, vis, e.dest, curr))
                    return true;
            } 
            //Case-1
            else if(vis[e.dest] && e.dest != par){
                return true;
            }
            //Case-2 -> (If neighbour is visited and also it is parent then) -> do nothing -> continue
        }
        return false;
    }
    public static void main(String args[]){
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);
        System.out.println("Cycle Present in Graph: "+ detectCycle(graph));

    }
}
