public class DiamterAppro2 {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
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
    static class Info {
        int diameter;
        int height;
        Info(int d, int h){
            diameter = d;
            height = h;
        }
    }
    
    static Info diameter(Node root) { //O(n)
        if(root == null) {
            return new Info(0, 0); //For null node height & diamter both will be 0
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        
        int finalDiam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), (leftInfo.height + rightInfo.height + 1));

        int finalHT = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(finalDiam, finalHT);
    }
   

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        System.out.println("Root Node: "+root.data);
        System.out.println("Diamter of Tree: "+diameter(root).diameter);
    }
}
