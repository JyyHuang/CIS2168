package Hw1;
import java.util.*;
// Question 2.5
public class InsertPlusSolution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(
        List.of("one", "two", "three", "four") );
        System.out.println("list = " + list);

        // insert a + in front of every list element
        for (int i = 0; i < list.size(); i+= 2){
            list.add(i, "+");
        }
        System.out.println("updated list = " + list);
    }
}
