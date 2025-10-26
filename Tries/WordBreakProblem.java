package Tries;

public class WordBreakProblem {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){ //O(L)
        Node curr = root;

        //Level-wise traversal
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word){  //O(L)
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            char c = word.charAt(level);
            if(curr.children[c -'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.eow;
    }
    public static void printTrie(Node node, String word){
        if(node.eow){
            System.err.println(word);
        }
        for(int i=0; i<26; i++){
            if(node.children[i] != null){
                printTrie(node.children[i], word + (char)(i + 'a'));
            }
        }
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){ //Used i=1 instead of '0' because in the substring(beg=0,end=i) where "end is not inclusive" so if i=0 then end=0 this leads to end=-1 which will outOfBound.
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String words[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        String key = "ilikesamsung";
        String key2 = "ilikesung";

        for(String word : words){
            insert(word);
        }
        //Print the Trie
        printTrie(root, "");

        System.out.println(wordBreak(key2));
    }
}


// 🔹 Time Complexity
// 1. Recursive branching

// For each prefix position i (1 → M):

// You make up to M recursive calls (key.substring(i)).

// So the recursion tree can have roughly 2^M branches in the worst case
// (each position can either break or not break).

// 2. search() cost inside the loop

// Each recursive level calls search() for O(M) per prefix.

// So total time =
// 👉 O(M) (search) × O(2^M) (recursion branches)

// ✅ Final Time Complexity: O(M × 2^M)
