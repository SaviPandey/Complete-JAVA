public class Factorial {
    public static int calcFact(int n){
        int fact=1;
        if(n==0 || n==1){
            return 1;
        }
        fact = n * calcFact(n-1);
        return fact;
    }
    //Sum n natural numbers
    public static int sumNatural(int n){
        if(n==1){
            return 1;
        }
        int sum = n + sumNatural(n-1);
        return sum;
    }
    //Fibonacci Series : Print Nth Fibonacci number
    public static int nthFibo(int n){
        if(n==1 || n==0){
            return n;
        }
        int fibnm1 = nthFibo(n-1);
        int fibnm2 = nthFibo(n-2);
        int fibN = fibnm1 + fibnm2 ;
        return fibN;
    }
    public static void main(String[] args) {
        int n = 6;
        // System.out.println(calcFact(n));
        // System.out.print(sumNatural(n));
        System.out.println(nthFibo(n));
    }
}

