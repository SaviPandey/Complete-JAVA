public class PowerOfN {
    public static int powerOf(int x, int n){
        if(n == 1){
            return x;
        }
        return x * powerOf(x, n-1);
    }
    public static void main(String[] args) {
        System.out.println(powerOf(5, 3));
    }
}
