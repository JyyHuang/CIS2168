package ClassFiles.Jantwentysix;

import java.util.Arrays;

public class IntCollection {
   private int[] a;

   public IntCollection(int[] keys) {
      a = Arrays.copyOf(keys, keys.length); // defensive copy
      Arrays.sort(a);
   }

   public boolean contains(int key) { return indexOf(key) != -1; }

   private int indexOf(int key) {
      // indexOf() implemented as a linear search.
      int l = 0;
      int r = a.length - 1;
      int mid;
      while (l <= r){
         mid = l + (r - l) / 2;
         if (a[mid] == key){
            return 0;
         }
         else if (a[mid] < key){
            l = mid + 1;
         }
         else{
            r = mid - 1;
         }
      }
      //for (int i : a){
      //   if (i == key){
      //      return 0;
      //   }
      //}
      return -1;
   }
}
