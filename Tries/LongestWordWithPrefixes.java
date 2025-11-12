package Tries;

public class LongestWordWithPrefixes {
    public static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int level=0; level < word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new Node();
            
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static void printTrie(Node node, String word){
        if(node.eow == true){
            System.out.println(word);
        }
        for(int i=0; i < 26; i++){
            if(node.children[i] != null){
                printTrie(node.children[i], word + (char)(i + 'a'));
            }
        }

    }
    //Find the longest word, whoes all the prefixes are also present in the array (If there are two words like here 'apply' & 'apple' then return the one lexicographically smalller else a "" string)
    public static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0; i < 26; i++){ // Order will be here a, b, c, d, ----> z   ; If we reverse this loop from i=25 to i >= 0 then we will get lexicographically larger as well
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char)(i + 'a');
                temp.append(ch);

                if(temp.length() > ans.length())  //Since we are only updating respect to size of string, so lexigraphically smaller string will be covered first, and later if same size string occurs then it will not update in answer. So the Lexicograph order is maintained
                    ans = temp.toString();

                longestWord(root.children[i], temp);
                //backtrack
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        for(String word : words){
            insert(word);
        }
        printTrie(root, "");

        longestWord(root, new StringBuilder(""));
        System.out.println("Longest String is: " + ans);
    }
}
