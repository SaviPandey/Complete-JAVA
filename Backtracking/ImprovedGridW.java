public class ImprovedGridW {
    public static int fact(int x){
        if(x == 1 || x == 0){
            return 1;
        }
        return x * fact(x - 1);
    }
    public static int gridWays(int i, int j, int n, int m){
        //Using the permutation formula
        return fact(n - 1 + m - 1)/ (fact(n-1) * fact(m-1)) ;
    }
    public static void main(String args[]){
        int n=3, m=3;
        System.out.println("Total Ways : "+gridWays(0, 0, n, m));
    }
}
