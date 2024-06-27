import java.util.*;
public class LowestCommonAncester {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) return false;

        path.add(root);     //Add the Node into arrayList

        if (root.data == n) return true;

        if(getPath(root.left, n, path) || getPath(root.right, n, path)) return true;   //If Node found on either left or Right then return true

        path.remove(path.size() - 1);  //If not found then remove the added node because that is not the path to node N
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        //Get the path from root to n1 & n2
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        }
        //Last equal node -> i-1th

        Node lca = path1.get(i-1);
        return lca;
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

        int n1 = 4, n2 = 5; 
        System.out.println(lca(root, n1, n2).data);
    }
}