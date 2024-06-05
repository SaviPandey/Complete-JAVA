public class PrintIncrease  {
    public static void printInc(int n){
        if(n==5){
            System.out.print(n);
            return;
        }
        System.out.print(n+" ");
        printInc(n+1);
    }
    public static void main(String args[]){
        int n=1;
        printInc(n);
    }
}
