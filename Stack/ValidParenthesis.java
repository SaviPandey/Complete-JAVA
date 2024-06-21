import java.util.*;
public class ValidParenthesis {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            //Opening
            if(c == '(' || c =='{' ||c == '[') {
                s.push(c);
            }
            //Closing 
            else {
                if(s.isEmpty()) return false;

                if(s.peek() == '{' && c == '}' || s.peek() == '(' && c == ')' || s.peek() == '[' && c == ']') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        return s.isEmpty();   //At end if stack is empty then true, else false
    }
    public static void main(String[] args) {
        String str = "()[]{}]";
        System.out.println(isValid(str));
    }
}
