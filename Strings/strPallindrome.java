public class strPallindrome{
    public static boolean checkPallindrome(String str){
        int n = str.length();
        for(int i=0; i<str.length()/2; i++){
            if( str.charAt(i) == str.charAt(n-i-1)){
                continue;
            }
            else{
               System.out.println("Not Pallidrome!");
               return false; 
            }
        }
        System.out.println("Yes, it is pallindrome");
        return true;
    }
    public static void main(String args[]){
        String str = "racecar";
        checkPallindrome(str);
    }
}