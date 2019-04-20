import model.StringTaskComparator;
import model.text.Text;
import service.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        String inputText = FileWork.readAsString("input.txt");
        Text convertedText = TextParser.parseText(inputText);
        System.out.println(inputText);

        Set<String> wordsFromInput = RegularExpressionFilter.firstVowelText(inputText);
        System.out.println("Input before sorting:\n" + wordsFromInput);

        Set<String> wordsFromConverted = RegularExpressionFilter.firstVowelText(convertedText);
        System.out.println("Converted before sorting:\n" + wordsFromConverted);
        System.out.println("Same? : "+ wordsFromConverted.equals(wordsFromConverted));

        Set<String> test = new TreeSet<>(new StringTaskComparator());
        test.addAll(RegularExpressionFilter.firstVowelText(inputText));
        System.out.println("\nAfter sorting:\n" +  test);

        Set<String> test2 = new TreeSet<>();
        for (String word: wordsFromInput) {
            test2.add(RegularExpressionFilter.firstConsonantWord(word));
        }
        System.out.println("Sorted by:\n" +  test2);

        System.out.println("Everything was sorted? : "+ wordsFromInput.equals(test));
    }
}
