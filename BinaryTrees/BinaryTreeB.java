public class BinaryTreeB {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    public static void preorderTraversal(Node root){
        if(root == null) { //For emmpty tree or Leaf node
            return;
        }
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int leftSub = height(root.left);
        int rightSub = height(root.right);

        int height = Math.max(leftSub, rightSub) + 1; //Maximum from both sub-trees and +1 for own

        return height;
    }
    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int lCount = countNodes(root.left);
        int rCount = countNodes(root.right);
        return lCount + rCount + 1; //count of leftSubtree + rightSubTree + 1 (for root node)
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root Data: "+root.data);

        System.out.print("Preorder: ");
        preorderTraversal(root);
        System.out.println();

        System.out.print("Inorder: ");
        inOrder(root);
        System.out.println();
        System.out.print("PostOrder: ");
        postOrder(root);
        System.out.println();
        System.out.println("Height: "+height(root));
        System.out.println("Number of Nodes: "+countNodes(root));
    }
}
