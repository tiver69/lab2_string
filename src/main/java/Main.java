import model.StringTaskComparator;
import service.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        String text = FileWork.readAsString("input.txt");
        System.out.println(text);

        HashSet<String> words = (HashSet<String>) RegularExpressionFilter.firstVowelText(text);
        System.out.println("Before sorting:\n" + words);

        Set<String> test = new TreeSet<String>(new StringTaskComparator());
        test.addAll(RegularExpressionFilter.firstVowelText(text));

        System.out.println("After sorting:\n" +  test);

    }
}
