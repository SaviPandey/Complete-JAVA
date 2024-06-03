import java.util.Arrays;
public class Anagrams {
    public static void main(String args[]){
        String str1 = "earth";
        String str2 = "heart";

        //Convert Strings to lowercase. Why? so thatwe don't have to checkseparately for lower & uppercase.
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        // First check - if the lengths are the sameif
        if(str1.length() == str2.length()){
            char[] str1Array = str1.toCharArray();
            char[] str2Array = str2.toCharArray();
            //sort the character array
            Arrays.sort(str1Array);
            Arrays.sort(str2Array);

            // if the sorted char arrays are sameor identical then the strings areanagram
            boolean result = Arrays.equals(str1Array, str2Array);
            if(result){
                System.out.println(str1+" and "+str2+" are anagrams of each other.");
            } else{
                System.out.println(str1+" and "+str2+" are not anagrams of each other.");
            }
        }
        else{
            System.out.println(str1+" and "+str2+" are not anagrams of each other.");
        }
    }
}
