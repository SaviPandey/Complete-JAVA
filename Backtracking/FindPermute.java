public class FindPermute {
    public static void findPermutation(String str, String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //Recursion - O(n * n!)
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i); 
            //"abcede" ="ab" + "de" ="abde"
            String newStr = str.substring(0, i) + str.substring(i+1); //this will remove the ith character
            findPermutation(newStr, ans+curr);
        }
    }
    public static void main(String args[]){
        String str = "abc";
        String ans = "";
        findPermutation(str, ans);
    }
}
