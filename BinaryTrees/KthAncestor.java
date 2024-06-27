public class KthAncestor {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static int kthAncestor(Node root, int n, int k) {
        if (root == null || k == 0) return -1;

        if(root.data == n) return 0;

        int leftDist = kthAncestor(root.left, n, k);
        int rightDist = kthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) return -1;
        
        int maxDist = Math.max(leftDist, rightDist);
        if(maxDist + 1 == k) {
            System.out.println(k+"th ancester of "+n+" : "+root.data);
        }

        return maxDist + 1;
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \  / \
                4   5 6  7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int node = 5, k = 1;                        //Second parent of Node:-5
        kthAncestor(root, node , k);
    }
}
