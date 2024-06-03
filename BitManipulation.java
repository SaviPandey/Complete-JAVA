public class BitManipulation {
    public static void oddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            System.out.println("Even Number"); 
        } else{
            System.out.println("Odd Number");
        }
    }
    public static int clearBitsInRange(int n , int i, int j){
        int a = ((~0)<<(j+1));
        int b = (1<<i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n){
        return (n & (n-1)) == 0;
    }
    public static int countSetBits(int n){
        int count =0;
        while(n > 0){
            if( (n & 1) != 0){ //check lSB
                count++;
            }
            n = n>>1 ;
        }
        return count;
    }

    public static int fastExponentiation(int a, int n){
        int ans = 1;
        while(n > 0){
            if((n & 1) != 0){
                ans *= a;
            }
            a *= a;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String args[]){
        oddOrEven(7);
        // System.out.println(clearBitsInRange(10, 2, 4));
        // System.out.println(isPowerOfTwo(15));
        // System.out.println(countSetBits(10));
        // System.out.println(fastExponentiation(5, 3));
    }
}
