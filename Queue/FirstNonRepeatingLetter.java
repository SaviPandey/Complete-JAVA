import java.util.*;
public class FirstNonRepeatingLetter {
    public static void firstNonRepeatingLetter(String str) {
        int freqMap[] = new int[26];  //'a' - 'z'
        Queue<Character> q = new LinkedList<>();
        for (char c : str.toCharArray()) {
            q.add(c);
            freqMap[c - 'a']++;

            while(!q.isEmpty() && freqMap[q.peek() - 'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek()+" ");
            }
        }    
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        firstNonRepeatingLetter(str);
    }
}
