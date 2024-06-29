//Given a BST covert it to Balanced BST(With minimum height BST)
import java.util.*;
public class CreateBalancedBST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    public static void inorder(Node root , ArrayList<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.data); //Add Inorder into the List
        inorder(root.right, list);
    }
    public static Node createBalancedBST(ArrayList<Integer> list, int start, int end) {
        if(start > end) return null;
        int mid = (start + end)/2;

        Node root = new Node(list.get(mid));
        root.left = createBalancedBST(list, start, mid - 1);
        root.right = createBalancedBST(list, mid + 1, end);

        return root;
    }

    //For check is Balanced Or Not using PreOrder
    public static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Sorted Inorder : ");
        inorder(root, list);    
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }    
        System.out.print("\nPreorder Before Balancing : ");
        preorder(root);


        root = createBalancedBST(list, 0, list.size() - 1);

        System.out.print("\nPreorder after Balancing : ");
        preorder(root);
    }
}
