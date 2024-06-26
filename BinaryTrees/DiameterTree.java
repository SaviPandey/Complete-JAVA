public class DiameterTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class BinaryTree {
        static int idx = -1;
        public Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        int ldiam = diameter(root.left);
        int rdiam = diameter(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiam = lh + rh + 1 ; //Diameter passes through root node

        return Math.max(selfDiam, Math.max(rdiam, ldiam));
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root Node: "+root.data);

        System.out.println("Diamter of Tree: "+diameter(root));
    }
}