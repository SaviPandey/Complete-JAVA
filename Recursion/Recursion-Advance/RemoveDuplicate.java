// Google & Microsoft : Remove duplicates in a String

public class RemoveDuplicate {
    public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx == str.length()){
            System.out.print(newStr);
            return ;
        }
        //Checking if character is alraedy present in map array or not

        char currChar = str.charAt(idx);

        if(map[currChar - 'a'] == true){ //Character already presnt
            // Dont append remove duplicxate
            removeDuplicate(str, idx+1, newStr, map);
        } 
        else{
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx+1, newStr.append(currChar), map);
        }
    }
    public static void main(String args[]){
        String str = "appnnacollege";
        removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
