import java.util.*;
public class Root2LeafPath {
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
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void printRoot2Lead(Node root, ArrayList<Integer> path) {
        if(root == null) return;

        path.add(root.data);

        if(root.left == null && root.right == null){  //Leaf Node
            printPath(path);
        }
        printRoot2Lead(root.left, path);
        printRoot2Lead(root.right, path);
        path.remove(path.size()-1); //Backtracking step
    }
    public static void main(String[] args) {
        int val[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
        Node root = null;
        for(int i=0; i<val.length; i++){
            root = insertNode(root, val[i]);
        }
        System.out.print("Inorder : ");
        inorder(root);
        System.out.println();
        printRoot2Lead(root, new ArrayList<>());
    }
}
