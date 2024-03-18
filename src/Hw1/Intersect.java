import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

public class Intersect {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1,4,8,9,11,15,17,28,41,59));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(4,7,11,17,19,20,23,28,37,59, 81));
        System.out.println("Before:");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println();
        System.out.println("After: " + intersect(list1, list2));

    }

    // List1 and list2 should be sorted
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2){
        // If list1 and list2 aren't sorted, we can sort them ourself. This makes time complexity worse
        // Collections.sort(list1);
        // Collections.sort(list2);

        int pList1 = 0;
        int pList2 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (pList1 < list1.size() && pList2 < list2.size()){
            if (list1.get(pList1).equals(list2.get(pList2))){
                result.add(list1.get(pList1));
                pList1++;
                pList2++;
            } else if (list1.get(pList1) < list2.get(pList2)){
                pList1++;
            } else if (list1.get(pList1) > list2.get(pList2)){
                pList2++;
            }
        }

        return result;
    }
}
