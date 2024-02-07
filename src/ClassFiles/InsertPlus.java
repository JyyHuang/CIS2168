package ClassFiles;

public class InsertPlus {
    public static void main(String[] args) {
        ResizingArrayList<String> list = new ResizingArrayList<>();
        list.add("one"); list.add("two"); list.add("three"); list.add("four");

        System.out.println(list);
        //insert "+"
        for (int i = 1; i < list.size(); i += 2){
            list.add(i,"+");
        }
        System.out.println(list);
    } 
}
