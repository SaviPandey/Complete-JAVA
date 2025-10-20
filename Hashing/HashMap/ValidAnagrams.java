package HashMap;
import java.util.HashMap;

//Time-Complexity : O(n)

public class ValidAnagrams {
    public static boolean isAnagram(String s, String t){
        HashMap<Character, Integer> hm = new HashMap<>();

        if(s.length() != t.length()){
            System.out.println("Not a Valid Anagram");
            return false;
        }

        //Add all the characters into the HashMAp
        for(int i=0; i<s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        //Traverse on 't' and remove the characters found in both
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);

            if(hm.containsKey(c)){
                hm.put(c, hm.get(c) - 1);
                if(hm.get(c) == 0){
                    hm.remove(c);   // remove entry when count becomes zero
                }
            } else{
                // Character not found in map => not an anagram
                System.out.println("Not a Valid Anagram");
                return false;
            }
        }

        // If map is empty, both strings are anagrams
        if (hm.isEmpty()) {
            System.out.println("Valid Anagram");
            return true;
        } else {
            System.out.println("Not a Valid Anagram");
            return false;
        }
    }

    public static void main(String args[]){
        String s = "knee";
        String t = "keens";

        isAnagram(s, t);
    }   
}
