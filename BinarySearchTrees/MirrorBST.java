public class MirrorBST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    public static Node insertNode(Node root, int  val){
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data > val) {
            root.left = insertNode(root.left, val);
        }
        else {
            root.right = insertNode(root.right, val);
        }

        return root;
    }
    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    public static Node mirrorBST(Node root) {
        if(root == null) return null;
        Node leftS = mirrorBST(root.left);
        Node rightS = mirrorBST(root.right);

        root.left = rightS;
        root.right = leftS;

        return root;
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
        Node root = null;
        for(int i=0; i < val.length; i++) {
            root = insertNode(root, val[i]);
        }
        System.out.print("Inorder Before : ");
        inorder(root);

        mirrorBST(root);
        System.out.print("\nInorder After : ");
        inorder(root);
    }
}
