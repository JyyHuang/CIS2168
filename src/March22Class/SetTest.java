package March22Class;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();        
        set.add("Aiko");
        set.add("Fluffy");
        set.add("Curly");
        set.add("Fluffy");
        set.add("Bob");
        set.add("Aiko");

        System.out.println(set);
    }
}
