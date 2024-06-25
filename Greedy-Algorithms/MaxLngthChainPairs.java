import java.util.*;
public class MaxLngthChainPairs {
    public static void main(String[] args) { //O(nLogn)
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};

        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int n = pairs.length;
        int chainLen = 1;
        int chainEnd = pairs[0][1]; //Last selected pair end
        for(int i=1; i<n; i++){
            if(pairs[i][0] > chainEnd) { // if (new Pair start) > (lastSelectedPair's end) 
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Maximum length of chain pairs is " + chainLen);
    }
}
