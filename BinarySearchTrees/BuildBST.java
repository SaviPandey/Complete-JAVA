public class BuildBST {
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
            //Left SubTree
            root.left = insertNode(root.left, val);
        } else {
            //Right Subtree
            root.right = insertNode(root.right, val);
        }
        return root;
    }
    public static void inorderTraversal(Node root) {
        if(root == null) return;

        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        int val[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i=0; i < val.length; i++) {
            root = insertNode(root, val[i]);
        }
        inorderTraversal(root);
    }
}
