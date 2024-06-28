public class SearchBST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    public static Node insertNode(Node root, int val) {
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            //Left subtree
            root.left = insertNode(root.left, val);
        } else {
            //Right subtree
            root.right = insertNode(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean foundKey(Node root, int key) {   //Time -> O(H) : height of tree
        if(root == null) return false;

        if(root.data == key) return true;  //FOund the key

        if(root.data > key) {
            //Left Subtree
            return foundKey(root.left, key);
        } else{
            //Right Subtree
            return foundKey(root.right , key);
        }
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
        Node root = null;
        for(int i=0; i<val.length; i++){
            root = insertNode(root, val[i]);
        }
        inorder(root);

        int k = 6; //Search this key
        System.out.println("\nFound key : "+foundKey(root, k));
    }
}
