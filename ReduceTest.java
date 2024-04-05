import java.util.HashMap;

public class ReduceTest {
   public HashMap<String, Integer> reduce(HashMap<String, Integer> map1,
                                          HashMap<String, Integer> map2) {
      // YOUR CODE HERE

      return null;
   }
   public static void main(String[] args) {
      HashMap map1 = new HashMap<String, Integer>();
      map1.put("aiko", 2);
      map1.put("fluffy", 5);
      map1.put("zugzwang", 10);
      System.out.println("map1: " + map1);

      HashMap map2 = new HashMap<String, Integer>();
      map2.put("fluffy", 1);
      map2.put("aiko", 5);
      map2.put("panda", 2222);
      System.out.println("map2: " + map2);

      HashMap result = new ReduceTest().reduce(map1, map2);
      // THE NEXT LINE PRODUCES THE CORRECT OUTPUT ONCE YOU IMPLEMENT the reduce() method
      System.out.println("result: " + result);


   }
}
