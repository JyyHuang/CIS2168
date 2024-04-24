/******************************************************************************
 *  Class:      Merge.java
 *  Depends on: In.java
 *  Data files: 10ints.txt, words3.txt
 *
 *  Sorts a sequence of integers from an input file using mergesort.
 *
 *  Example:
 *  % more 10ints.txt
 *  10                        [first  line: how many integers to sort]
 *  4 1 3 2 16 9 10 14 8 7    [second line: the integers to sort ]
 *
 ******************************************************************************/

//  The Merge class provides static methods for sorting a list of Comparable
//  objects using mergesort.
public class Merge {

   // This class should not be instantiated.
   private Merge() { }

   // Rearranges the array in ascending order, using the natural order.
   public static void sort(Comparable[] a) {
      Comparable[] aux = new Comparable[a.length];
      // YOUR CODE HERE
   }

   // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
   private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
      // YOUR CODE HERE
   }

   // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
   private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

      // copy to aux[]
      for (int k = lo; k <= hi; k++) {
         aux[k] = a[k];
      }

      // merge back to a[]
      int i = lo, j = mid+1;
      for (int k = lo; k <= hi; k++) {
         if      (i > mid)              a[k] = aux[j++];
         else if (j > hi)               a[k] = aux[i++];
         else if (less(aux[j], aux[i])) a[k] = aux[j++];
         else                           a[k] = aux[i++];
      }
   }

   /* A helper method: is x less than y? */
   private static boolean less(Comparable x, Comparable y) {
      return x.compareTo(y) < 0;
   }

   // print array to standard output
   private static void show(Comparable[] a) {
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");
      System.out.println();
   }

   // Reads in a sequence of Comparable objects; mergesorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      /* TEST 1: Sorting a list of integers */
      In in = new In("10ints.txt");
      int n = in.readInt();
      Integer[] a = new Integer[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }
      Merge.sort(a);
      show(a);

      /* TEST 2: Sorting a list of words */
      In in2 = new In("words3.txt");
      String[] s = in2.readAllStrings();
      Merge.sort(s);
      show(s);
   }
}
