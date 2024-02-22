package Hw5;
import java.util.Stack;

public class BracketMatcher {

   public static void main(String[] args) {
      In in = new In("./src/Hw5/testCustom.txt");
      String text = in.readAll();
      System.out.println("processing: " + text); // comment out or delete this line before submitting
      Stack<Character> openingBrackets = new Stack<>();
      for (int position = 1; position <= text.length(); ++position) {
         char next = text.charAt(position - 1);

         /* YOUR CODE HERE */
         if (next == '[' || next == '(' || next == '{'){
            openingBrackets.push(next);
         } else if (next == ']' && (openingBrackets.isEmpty() || openingBrackets.pop() != '[')){
            System.out.println(position);
            System.exit(0);
         } else if (next == ')' && (openingBrackets.isEmpty() || openingBrackets.pop() != '(')){
            System.out.println(position);
            System.exit(0);
         }  else if (next == '}' && (openingBrackets.isEmpty() || openingBrackets.pop() != '{')){
            System.out.println(position);
            System.exit(0);
         }
      }
      if (!openingBrackets.isEmpty()){
         System.out.println(openingBrackets.size());
         System.exit(0);
      }
      // Print "Success" if brackets are balanced
      /* YOUR CODE HERE */
      System.out.println("Success");
   }
}

