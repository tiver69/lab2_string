package service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionFilter {

    private static String firstVowelTextPattern = "\\b[AEIOUYaeiouy].*?\\b";
    private static String firstConsonantWordPattern = "[^AEIOUYaeiouy].*?$";
    private static String twoMoreSpacesPattern = "[\\s]{2,}";
    private static String delimiterBeforePunctuationPattern = "\\b [.,?!]";
    private static String wordAfterPunctuationPattern = "[.,?!]\\b";

    public static Set<String> firstVowelText(String text){

        Matcher m = Pattern.compile(firstVowelTextPattern)
                .matcher(correctDelimiters(text));
        Set<String> words = new HashSet<>();
        while (m.find()){
//            System.out.print(m.group() + "-");
            words.add(m.group().toLowerCase());
        }
        return words;
    }

    public static String firstConsonantWord(String word){
        Matcher m = Pattern.compile(firstConsonantWordPattern).matcher(word);
        int count = 0;
        String buff = "";

        while (m.find()){
            count++;
            buff = m.group();
//            System.out.println(buff);
        }
        if (count == 1)
            return buff;
        if (count == 0)
            return word;
        else return "";
    }

    public static String correctDelimiters(String text){

        return removeDelimitersBeforePunctuation(
                enterSpaceAfterPunctuation(text)
        );
    }

    private static String enterSpaceAfterPunctuation(String text){
        String resultText =  removeSpaces(text);

        Matcher m3 = Pattern.compile(wordAfterPunctuationPattern).matcher(resultText);
        StringBuilder resultBuilder = new StringBuilder("");
        int last = 0;

        while (m3.find()) {
            int start = m3.start();
            int end = m3.end();
//            System.out.println("Найдено совпадение \"" + result.substring(start,end) + "\" с "+ start + " по " + (end-1) + " позицию");
//            System.out.println("'"+result.substring(start,end) + "' - '"+ result.charAt(end-1)+"'");
            resultBuilder.append(resultText.substring(last, start)).append(resultText.charAt(end-1))
                    .append(" ");
            last = end;
        }
        resultBuilder.append(resultText.substring(last));

        return resultBuilder.toString();
    }


    private static String removeDelimitersBeforePunctuation(String text){
        String resultText =  removeSpaces(text);

        Matcher m2 = Pattern.compile(delimiterBeforePunctuationPattern)
                .matcher(resultText);
        StringBuilder resultBuilder = new StringBuilder("");

        int last = 0;
        while (m2.find()) {
            int start = m2.start();
            int end = m2.end();
//            System.out.println("Найдено совпадение \"" + result.substring(start,end) + "\" с "+ start + " по " + (end-1) + " позицию");
//            System.out.println("'"+result.substring(start,end) + "' - '"+ result.charAt(end-1)+"'");
            resultBuilder.append(resultText.substring(last, start)).append(resultText.charAt(end-1));
            last = end;
        }
        resultBuilder.append(resultText.substring(last));

        return resultBuilder.toString();
    }

    public static String removeSpaces(String text){
        String result = text.trim();
        return result.replaceAll(twoMoreSpacesPattern," ");
    }

}
