public class PrintInRange {
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

    public static void printInRange(Node root, int low, int high) {
        if(root == null) return;

        if(root.data >= low && root.data <= high) {
            printInRange(root.left, low, high);
            System.out.print(root.data+" ");
            printInRange(root.right, low, high);
        } 
        else if(root.data < low) {
            printInRange(root.right, low, high);
        } else {
            printInRange(root.left, low, high);
        }

    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
        Node root = null;
        for(int i=0; i<val.length; i++){
            root = insertNode(root, val[i]);
        }
        System.out.print("Inorder : ");
        inorder(root);

        System.out.print("\nIn Range : ");
        printInRange(root, 5, 12);
}
}
