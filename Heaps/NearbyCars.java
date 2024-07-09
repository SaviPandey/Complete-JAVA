import java.util.PriorityQueue;
public class NearbyCars {
    static class Points implements Comparable<Points> {
        int x, y;
        int distSq ;  //x^2 + y^2
        int idx;
        public Points(int x , int y , int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Points p2)  {
            return this.distSq - p2.distSq; //Ascending Order
        }
    }
    public static void main(String[] args) {
        int[][] pts = {{3,3}, {5, -1}, {-2, 4}};
        int k = 2;
        PriorityQueue<Points> pq = new PriorityQueue<>();

        for(int i = 0; i < pts.length ; i++) {
            int distSq = pts[i][0]*pts[i][0]  + pts[i][1]*pts[i][1];
            pq.add(new Points(pts[i][0], pts[i][1], distSq, i));
        }
        //Nearest k cars
        for(int i=0; i<k ; i++) {
            System.out.println("C"+pq.remove().idx);
        }
    }
}
