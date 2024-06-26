import java.util.*;

public class KthLvlOfTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    //Recursive Approach
    // public static void kthLevel(Node root, int k) {
    //     if (root == null) return;
    //     if(k == 1){
    //         System.out.print(root.data + " ");
    //     }
    //     else {
    //         kthLevel(root.left, k - 1);
    //         kthLevel(root.right, k - 1);
    //     }    
    // }

    //Iterative approach
    public static void kthLevel(Node root, int k) {
        if (root == null) return;                   //Tree is Null
        if (k == 0) {                               //Level - 0
            System.out.print(root.data + " ");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (level == k) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (level == k) {
                break;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int k = 2;
        kthLevel(root, k);
    }
}
