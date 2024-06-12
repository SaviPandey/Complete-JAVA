public class Subsets {
    public static void findSubsets(String str , String ans, int i){
        //base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.print("Null");
            }else{
            System.out.print(ans+" ->");
            }
            return;
        }
        //Recursion
        //Yes Choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //No choice
        findSubsets(str, ans, i+1);
    }
    public static void main(String args[]){
        String str= "abc";
        String ans ="";
        findSubsets(str, ans, 0);
    }
}
