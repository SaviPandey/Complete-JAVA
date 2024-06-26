import java.util.*;
public class TopViewOfTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class Info {
        Node node;
        int horizontalDist;

        Info(Node n, int hd) {
            node = n;
            horizontalDist = hd;
        }
    }
    public static void topView(Node root) {
        if(root == null) return;

        //Level-Order Traversal
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        q.add(new Info(root, 0));  //Horizontal distn of root node is 0
        q.add(null); //For nextLine;

        int min = 0, max = 0;

        while(!q.isEmpty()) {
            Info curr = q.poll();

            if(curr == null) {
                if(q.isEmpty()){ 
                    break;
                } else {
                    q.add(null);
                }
            } else {

                if(!map.containsKey(curr.horizontalDist)) { //FIrst time this Hori-dist is occuring
                    map.put(curr.horizontalDist, curr.node);
                }
                
                //Add left and right nodes
                if(curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.horizontalDist - 1));  //For left nodes Hd - 1
                    min = Math.min(min , curr.horizontalDist - 1);
                }
                if(curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.horizontalDist + 1));  //For right nodes HD + 1
                    max = Math.max(max , curr.horizontalDist + 1);
                }
            }

            
        }

        //Print the Top-View
        for(int i = min ; i <= max; i++) {
            System.out.print(map.get(i).data+ " "); //Print the value of Node
        }

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
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.print("Top View of Binary Tree: ");
        topView(root);
    }
}
