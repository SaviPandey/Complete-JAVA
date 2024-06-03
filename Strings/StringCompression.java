public class StringCompression {
    public static void compress(String str){
        StringBuilder newStr = new StringBuilder("");

        for(int i=0; i<str.length(); i++){   //O(n)  
            int count =1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;                                        // bcoz i will be increment here so time cpmplex will not be O(n^2)
            }
            newStr.append(str.charAt(i));
            if(count>1){
                newStr.append(count);
            }
        }
        newStr.toString();
        System.out.print(newStr);
    }
    public static void main(String[] args) {
        String str = "abbcccdd";
        compress(str);
    }
}
