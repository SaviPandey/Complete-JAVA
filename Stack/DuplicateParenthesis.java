import java.util.*;
public class DuplicateParenthesis {
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);     

            //Closing-Condition
            if(ch == ')') {
                int count = 0; 
                while(s.peek() != '(') { //assumption is that it is a valid string so no need of -> !s.isEmpty()
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true; //Duplicate exists
                } else {
                    s.pop(); //opening pair
                }
            } else {            
                //Opening-Condition
                s.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "(((a+b)*(b-c)))";
        System.out.println(isDuplicate(str));
    }
}
