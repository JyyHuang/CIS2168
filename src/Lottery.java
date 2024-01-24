import java.util.*;

public class Lottery
{
   public static void main(String[] args)
   {
      int n = 49; // 1 through n is the set of numbers to draw from
      int k = 6;  // how many numbers will be drawn from this set

      int[] numbers = new int[n];
      // fill the first array with numbers 1 2 3 . . . n
      for (int i = 1; i <= n; i++){
         numbers[i - 1] = i;
      }

      int[] result = new int[k];
      // draw k numbers from the first array and put them into the second
      for (int i = 0; i < k; i++)
      {
         // make a random index between 0 and n - 1
         int r = (int)(Math.random() * n);

         // pick the element at that random index
         result[i] = numbers[r];
         
         // move the last element (of the first array) into the random location
         numbers[r] = numbers[n - 1];

         n--;
      }

      // print the sorted array
      System.out.println("Draw the following integers " +
            "from the set 1 to " + (n + k) + ":");
      // YOUR CODE HERE
      System.out.println(Arrays.toString(result));
   }
}