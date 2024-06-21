import java.util.*;
public class MaxAreaInHistogram {
    public static int maxArea(int hts[]){
        int n = hts.length;
        int maxArea = 0;

        int nSL[] = new int[hts.length];
        int nSR[] = new int[hts.length];
        
        //Next Smaller Right
        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--){
            //Pop-condition
            while(!s.isEmpty() && hts[s.peek()] >= hts[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nSR[i] = n;
            } else {
                nSR[i] = s.peek();
            }
            s.push(i);
        }

        System.out.println(Arrays.toString(nSR));

        //Next Smaller Left
        s = new Stack<>();

        for(int i=0; i<n; i++){
            //Pop-condition
            while(!s.isEmpty() && hts[s.peek()] >= hts[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nSL[i] = -1;
            } else {
                nSL[i] = s.peek();
            }
            s.push(i);
        }
 
        System.out.println(Arrays.toString(nSL));

        //Current Area -> (j - i - 1) -> (nSR[i] - nSL[i] - 1)
        for(int i=0; i<hts.length ; i++){
            int height = hts[i];
            int width = nSR[i] - nSL[i] - 1;
            int currentArea = height * width;

            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2, 1, 5, 6, 2, 3};
        System.out.println("Maximum Area of Histogram : "+ maxArea(heights));;

    }
}