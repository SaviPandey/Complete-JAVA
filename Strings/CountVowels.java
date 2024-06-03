import java.util.*;
public class CountVowels {
    public static void main(String args[]){
        @SuppressWarnings("resource")
        String str= new Scanner(System.in).next();
        int count=0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch=='u'){
                count++;
            }
        }
        System.out.println("Number of Vowels: "+count);
    }
}
