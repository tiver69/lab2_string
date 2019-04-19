import service.*;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        String text = FileWork.readAsString("input.txt");
        System.out.println(text);

        HashSet<String> words = (HashSet<String>) RegularExpressionFilter.firstVowel(text);

        System.out.println("\n" + words);
    }
}
