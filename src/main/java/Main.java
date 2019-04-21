import model.StringTaskComparator;
import model.text.Text;
import service.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String inputText = FileWork.readAsString("input.txt");
        Text convertedText = TextParser.parseText(inputText);
        System.out.println(inputText);

        long time = System.currentTimeMillis();
            List<String> wordsFromInput = new ArrayList<>(RegularExpressionFilter.firstVowelText(inputText));
            System.out.println("Input before sorting:\n" + wordsFromInput);
            wordsFromInput.sort(new StringTaskComparator());
            System.out.println("After sorting:\n" +  wordsFromInput + "");
        System.out.println("Time with string variable: " + (System.currentTimeMillis() - time) + "\n");

        time = System.currentTimeMillis();
            List<String> wordsFromConverted = new ArrayList<>(RegularExpressionFilter.firstVowelText(convertedText));
            System.out.println("Converted before sorting:\n" + wordsFromConverted);
            wordsFromConverted.sort(new StringTaskComparator());
            System.out.println("After sorting:\n" +  wordsFromConverted);
        System.out.println("Time with Text variable: " + (System.currentTimeMillis() - time));
        System.out.println("Same? : "+ wordsFromInput.equals(wordsFromConverted));

        List<String> test3 = new ArrayList<>();
        for (String word: wordsFromInput) {
            test3.add(RegularExpressionFilter.firstConsonantWord(word));
        }
        System.out.println("\nSorted by:\n" +  test3);
    }
}
