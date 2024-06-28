public class ValidateBST {
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

    public static boolean isBST(Node root, Node min , Node max){
        if(root == null) return true;

        if(min != null && root.data <= min.data){
            return false;
        } 
        else if(max != null && root.data >= max.data){
            return false;
        }
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
        Node root = null;
        for(int i=0; i<val.length; i++){
            root = insertNode(root, val[i]);
        }
        System.out.print("Inorder : ");
        inorder(root);
        System.out.println();
        System.out.println("Is BST : "+isBST(root, null, null));
    }
}
