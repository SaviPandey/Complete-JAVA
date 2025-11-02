package Tries;

public class PrefixProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        //Level-wise traversal
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            } else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans){
        if(root == null){
            return;
        }
        if(root.freq == 1){
            System.out.print(ans+", ");
            return;
        }

        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
                findPrefix(root.children[i], ans + (char)(i + 'a'));
            }
        }
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
    public static void main(String args[]){
        String[] words = {"zebra", "dog", "duck", "dove"};
        for(String word : words){
            insert(word);
        }
        printTrie(root, "");

        root.freq = -1;

        //Find the Unique Prefix array
        System.out.print("Unique Prefix Array -> {");
        findPrefix(root, "");
        System.out.print("}");
    }
}
