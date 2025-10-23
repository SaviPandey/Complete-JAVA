    package Tries;

    public class BasicOperationsTrie {
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
        
        public static void insert(String word){
            Node curr = root;

            //Level-wise traverse
            for(int level=0; level<word.length(); level++){
                int idx = word.charAt(level) - 'a';

                if(curr.children[idx] == null){
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }

            curr.eow = true;
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

        public static void main(String[] args) {
            String words[] = {"the", "a", "there", "their", "any", "thee"};

            for (String w : words) {
                insert(w);
            }

            System.out.println("Words in Trie:");
            printTrie(root, "");
        }
    }
