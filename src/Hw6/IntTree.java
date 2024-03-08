package Hw6;

public class IntTree {
    private Node root;

    // Inner class: implements a binary tree node
    private static class Node {
        int data;          // value stored at this node
        Node left, right;  // left and right subtrees of this node

        /* Constructor: creates a Node referring to two null subtrees */
        public Node(int data) { this(data, null, null); }

        /* Constructor: creates a Node referring to two subtrees */
        public Node(int data, Node left, Node right) {
            this.data  = data;
            this.left  = left;
            this.right = right;
        }
    }

    public IntTree(int size) { root = buildTree(1, size); }

    // Returns a sequential tree with n as its root when n <= size;
    //  if n > size, returns an empty tree.
    private Node buildTree(int n, int size) {
        if (n > size) return null;
        else {
            Node left  = buildTree(2*n,     size);
            Node right = buildTree(2*n + 1, size);
            return new Node(n, left, right);
        }
    }

    // prints the contents of this tree in inorder
    public void inorderTraversal() {
        System.out.print("inorder: ");
        inorderHelper(root);
    }

    // prints the inorder traversal of a tree with a given root
    private void inorderHelper(Node node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print(" " + node.data);
            inorderHelper(node.right);
        }
    }

    // prints the contents of this tree in preorder
    public void preorderTraversal() {
        System.out.print("preorder: ");
        preorderHelper(root);
    }

    private void preorderHelper(Node node){
        if (node != null) {
            System.out.print(" " + node.data);
            preorderHelper(node.left);
            preorderHelper(node.right);
        }
    }

    // prints the contents of this tree in postorder
    public void postorderTraversal() {
        System.out.print("postorder: ");
        postorderHelper(root);
    }

    private void postorderHelper(Node node){
        if (node != null) {
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(" " + node.data);
        }
    }

    // prints this tree "sideways," one node value per line. The
    // values are indented according to their levels in the tree.
    public void printSideways() { printSideways(root, 0); }

    // prints the tree rooted at a given node and a given level;
    // trees are printed "sideways," each node indented by its level
    private void printSideways(Node root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("     ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
    
    // returns the sum of values in the tree
    public int sum(){
        return sumHelper(root); 
    }

    private int sumHelper(Node root){
        if (root == null){
            return 0;
        }
        return root.data + sumHelper(root.left) + sumHelper(root.right);
    }
        
    // returns the number of tree levels
    public int countLevels(){
        return countLevelsHelper(root);
    }

    private int countLevelsHelper(Node root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(countLevelsHelper(root.left), countLevelsHelper(root.right));
    }
    
    // returns the number of leaf node
    public int countLeaves(){
        return countLeavesHelper(root);
    }

    private int countLeavesHelper(Node root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return countLeavesHelper(root.left) + countLeavesHelper(root.right);
    }

    // IntTree Client
    public static void main(String[] args) {
        IntTree intTree = new IntTree(7); // builds a sequential tree of size 7
        intTree.printSideways();               // prints the tree sideways
        intTree.inorderTraversal();            // prints "inorder: 4 2 5 1 6 3 7"
        System.out.println();
        intTree.preorderTraversal();
        System.out.println();
        intTree.postorderTraversal();
        System.out.println();
        System.out.println(intTree.sum());
        System.out.println(intTree.countLevels());
        System.out.println(intTree.countLeaves());
    }
}
