import java.util.*;

public class BSTValidator {
    static class BST {
        Integer value; // this node's data
        BST left, right; // this node's children
        // Constructor: initializes data and makes this a leaf node

        public BST(Integer data) {
            this(data, null, null);
        }

        // Constructor: initializes node data and sets its subtrees
        public BST(Integer key, BST left, BST right) {
            this.value = key;
            this.left = left;
            this.right = right;
        }
    }

    public boolean validate(BST tree, int min, int max) {
        if (tree == null)
            return true;
        if (tree.value <= min || tree.value >= max)
            return false;
        return validate(tree.left, min, tree.value) &&
                validate(tree.right, tree.value, max);
    }

    public static void main(String[] args) {
        BSTValidator answer = new BSTValidator();
        /* Test 1: a tree with a single node should be a binary tree */
        BST bt = new BST(2);
        show(bt);
        System.out.println(
                "Test 1. Is BST: " +
                        answer.validate(bt, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true
        /* Test 2: a 3-node BST */
        bt = new BST(6, new BST(1), new BST(8));
        show(bt);
        System.out.println(
                "Test 2. Is BST: " +
                        answer.validate(bt, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true
        /* Test 3 - a 3-node tree that is not a binary tree */
        bt = new BST(6, new BST(8), new BST(1));
        System.out.println(
                "Test 3. Is BST: " +
                        answer.validate(bt, Integer.MIN_VALUE, Integer.MAX_VALUE)); // false
        /* Test 4 - a bigger binary tree */
        bt = new BST(6, new BST(1), new BST(8));
        bt.left.left = new BST(-8);
        bt.right.left = new BST(7);
        show(bt);
        System.out.println(
                "Test 4. Is BST: " +
                        answer.validate(bt, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true
        /* Test 5 - a bigger binary tree */
        bt = new BST(6, new BST(1), new BST(8));
        bt.left.left = new BST(-8);
        bt.right.left = new BST(5);
        show(bt);
        System.out.println(
                "Test 5. Is BST: " +
                        answer.validate(bt, Integer.MIN_VALUE, Integer.MAX_VALUE)); // false
    }

    // helper for testing: prints a tree level-by-level
    public static void show(BST bt) {
        Queue<BST> q = new LinkedList<>();
        q.add(bt);
        while (!q.isEmpty()) {
            BST t = q.remove();
            if (t == null)
                continue;
            System.out.printf("%s ", t.value); // output node data
            q.add(t.left);
            q.add(t.right);
        }
        System.out.println();
    }
}
