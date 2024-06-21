import java.util.*;
public class StockSpanProblem {
    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);  //Push the first index as highest till date

        for(int i=1; i<stocks.length; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice >= stocks[s.peek()]) { //CurrPrice is greater means we have to pop from stack until prevMax
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek(); //prevMax = s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String args[]) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];

        stockSpan(stocks, span);

        for(int i = 0; i<span.length; i++){
            System.out.print(span[i]+" ");
        }
    }
}
