// Amazon - Tiling Problem

public class TilingProblem {
    public static int tilingProb(int n){ //2 x n (florr size)
        if(n==0 || n==1){
            return 1;       //only 1 way to put tile
        }
        // vertical tile place
        int fnm1 = tilingProb(n-1);

        // horizontal tile place
        int fnm2 = tilingProb(n-2);

        int tolWays = fnm1 + fnm2;
        return tolWays;

    }
    public static void main(String args[]){
        int n =4;
        System.out.println(tilingProb(n));
    }                                         
    
}
