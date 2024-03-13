package ClassFiles;

import Hw5.Stack;

public class SumStack {
    public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();  // Create a Stack here
      for (int i = 5; i >= 1 ; i--)
        stack.push(i);
      System.out.println(stack); // [1, 2, 3, 4, 5]
      System.out.println(sum(stack));
      System.out.println(stack);
   }

   /* returns the sum of the elements in Queue q */
   public static int sum(Stack<Integer> s) {
      int sum = 0;
      // YOUR CODE HERE
      int size = s.size();
      for (int i = 0; i < size; i++){
        sum += s.pop();
      }
      return sum;
   }
}