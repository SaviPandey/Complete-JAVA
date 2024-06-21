import java.util.*;
public class ReverseString {
    public static String reverseString(Stack<Character> s, String str) {
        int idx = 0;
        while(idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        Stack<Character> s = new Stack<>();
        String str = "Savinay Pandey";

        String res = reverseString(s, str); 
        System.out.println(res);

    }
}
