//Paytm interviews
//Print all binary numbers of size N without consecutive 1's
public class BinaryStringProb {
    public static void printBinStrings(int n, int lastPlace , String str){
        //base case
        if(n==0){
            System.out.println(str);
            return;
        }
        
        printBinStrings(n-1 , 0 , str+"0");
        if(lastPlace == 0){
            printBinStrings(n-1 , 1 , str+"1");
        }
    }
    public static void main(String args[]){
        printBinStrings(3 , 0 , new String(""));
    }
}
