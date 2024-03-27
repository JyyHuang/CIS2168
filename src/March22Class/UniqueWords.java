package March22Class;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) throws FileNotFoundException{
        Set<String> words = new TreeSet<>();
        Scanner in = new Scanner(new File("src/March22Class/mobydick.txt")); 
        while(in.hasNext()){
            String word = in.next();
            word = word.toLowerCase();

            if (word.startsWith("a") && word.length() == 3)
                words.add(word);
        }
        //while (in.hasNext()) {
        //    words.add(in.next().toLowerCase());
        //}
        //System.out.println(words.size());

        System.out.println("Three-letter 'c' words = " + words);
        in.close();
    }
}
