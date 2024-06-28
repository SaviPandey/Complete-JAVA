public class DeleteNode {
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

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    
    public static Node delete(Node root, int val) {
        if(root.data < val) {
            //Right subtree
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            //Left Subtree
            root.left = delete(root.left, val);
        }
        else { //Voila
            //Case-1 :-> No child
            if(root.left == null && root.right == null) {
                return null;
            }

            //Case-2 :-> One child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            //Case-3 :-> Two children
            Node IS = findInorderSuccessor(root.right);  //IS -> leftMost node in Right Subtree
            root.data = IS.data;  //Replace parent with IS.data
            root.right = delete(root.right, IS.data);  //Delete Original IS node

        }
        return root;
    }

    public static void main(String[] args) {
        int val[] = {8, 5, 3, 6, 1, 4, 10, 11, 14};
        Node root = null;
        for(int i=0; i<val.length; i++){
            root = insertNode(root, val[i]);
        }
        inorder(root);

        int k = 6; //Delete this Node


        root = delete(root, k); 
        //After Delete Print
        System.out.println();
        inorder(root);
    }
}
