public class SumTree {
    static class Node  {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static int transformTree(Node root) {
        if(root == null) return 0;

        int leftChild = transformTree(root.left);
        int rightChild = transformTree(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        root.data = (newLeft + leftChild) + (newRight + rightChild);

        return data;
    }
    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \  / \
                4   5 6  7

                Expected Sum Tree :
                    27
                    / \
                    9  13
                   / \ / \
                   0 0 0  0
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transformTree(root);
        preOrder(root);
    }
}
