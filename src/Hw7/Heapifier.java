import java.util.Arrays;

public class Heapifier {
    // Clients shouldn't instantiate this class (use it as shown in main())
    private Heapifier() {
    };

    // converts array a into a heap
    public static void heapify(Comparable[] a) {
        for (int i = a.length / 2; i >= 1; i--) {
            sink(a, i, a.length);
        }
    }

    // restores the heap invariant for the subtree rooted at index k
    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }

    // Helper methods for comparisons and swaps.
    // Indices are "off-by-one" to support 1-based indexing.
    private static boolean less(Comparable[] a, int i, int j) {
        // if left is less than right, it returns true
        // if left is greater than right, it returns false
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }

    // test case (add your own)
    public static void main(String[] args) {
        Character[] letters = { 'P', 'L', 'A', 'Y', 'G', 'R', 'O', 'U', 'N', 'D' };
        System.out.println(Arrays.toString(letters)); // prints
        // [P, L, A, Y, G, R, O, U, N, D]
        Heapifier.heapify(letters);
        System.out.println(Arrays.toString(letters)); // prints [Y, U, R, P, G, A, O, L, N, D]



        Character[] letters2 = { 'M', 'I', 'S', 'C', 'O', 'U', 'N', 'T', 'E', 'D' };
        System.out.println(Arrays.toString(letters2)); 
        Heapifier.heapify(letters2);
        System.out.println(Arrays.toString(letters2));
    }
}
