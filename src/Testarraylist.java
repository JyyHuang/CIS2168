import java.util.ArrayList;

public class Testarraylist {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        for (int i = 1; i <= list.size(); i += 2){
            list.add(i, "+");
        }

        System.out.println(list);
    }
}
