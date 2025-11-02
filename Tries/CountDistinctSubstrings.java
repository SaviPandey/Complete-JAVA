package Tries;

public class CountDistinctSubstrings {
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
        for (int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        Node curr = root;

        for(int level=0; level<key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public static void printTrie(Node node, String word){
        if(node.eow == true){
            System.out.println(word);
        }
        for(int i=0; i<26; i++){
            if(node.children[i] != null){
                printTrie(node.children[i], word + (char)(i + 'a'));
            }
        }
    }


    public static int countDistinctSubstrings(Node root){   //Counting the Node's created after inserting the suffixes in trie
        if(root == null){
            return 0;
        }

        int count =0;
        for(int i=0; i < 26; i++){
            if(root.children[i] != null){
                count += countDistinctSubstrings(root.children[i]);
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        // String str = "ababa";
        String str2 = "apple";
        
        //Step1 : Take all suffixes and insert into trie
        for(int i=0; i < str2.length(); i++){
            insert(str2.substring(i));
        }
        printTrie(root, "");

        System.out.println("Number of unique subtrings is "+countDistinctSubstrings(root));
    }
}
