import java.util.*;
public class Merge2BST {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) return;
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> finalArr, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;

        Node root = new Node(finalArr.get(mid));
        root.left = createBST(finalArr, start, mid - 1);
        root.right = createBST(finalArr, mid + 1, end);

        return root;
    }
    public static Node mergeBSTs(Node bst1, Node bst2) {
        //Get inorder for Both BST's
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(bst1, inorder1); 

        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(bst2, inorder2);
        
        //Merge Both List's
        int i = 0 , j = 0;
        ArrayList<Integer> mergedInorder = new ArrayList<>();
        while(i < inorder1.size() && j < inorder2.size()) {
            if(inorder1.get(i) < inorder2.get(j)) {
                mergedInorder.add(inorder1.get(i));
                i++;
            } else {
                mergedInorder.add(inorder2.get(j));
                j++;
            }
        }
        while(i < inorder1.size()) {
            mergedInorder.add(inorder1.get(i));
            i++;
        }
        while(j < inorder2.size()) {
            mergedInorder.add(inorder2.get(j));
            j++;
        }

        //Create BST from Merged Inorder
        return createBST(mergedInorder, 0, mergedInorder.size() - 1);
    }
    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Node bst1 = new Node(2);
        bst1.left = new Node(1);
        bst1.right  = new Node(4);

        Node bst2 = new Node(9);
        bst2.left = new Node(3);
        bst2.right = new Node(12);

        Node root = mergeBSTs(bst1, bst2);
        preOrder(root);
    }
}