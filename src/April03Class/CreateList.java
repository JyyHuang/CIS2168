import java.util.*;

public class CreateList {
  static List<Integer> nodeList = new ArrayList<>();

  public static List<Integer> createList(Tree<Integer> node) {
    if (node == null) {
      return null;
    }
    nodeList.add(node.data);
    createList(node.left);
    createList(node.right);
    return nodeList;
  }

  // inner class, represents a binary tree
  static class Tree<Integer> {
    int data;   // node data
    Tree left;  // this tree's left subtree
    Tree right; // this tree's right subtree

    // constructor: initializes data, sets subtrees to null
    public Tree(int value) { this.data = value; }
  }

  public static void show(Tree bt) {
    Queue<Tree> q = new LinkedList<>();
    q.add(bt);
    while (!q.isEmpty()) {
      Tree t = q.remove();
      if (t == null)
        continue;
      System.out.printf("%s ", t.data); // output node data
      q.add(t.left);
      q.add(t.right);
    }
  }

  public static void main(String[] args) {
    Tree<Integer> rt = new Tree<>(7);
    rt.left = new Tree(1);
    rt.left.left = new Tree(8);
    rt.left.right = new Tree(4);
    rt.left.right.left = new Tree(7);
    rt.left.right.right = new Tree(9);
    // right subtree of rt
    rt.right = new Tree(6);
    rt.right.left = new Tree(5);
    show(rt);

    // AFTER YOU'VE IMPLEMENTED THE createList METHOD, LINE 45 WILL PRINT THE
    // CORRECT OUTPUT
    System.out.println();
    List<Integer> test = createList(rt);
    System.out.println(test);
  }
}
