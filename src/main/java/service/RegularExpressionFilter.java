package service;

import model.text.Grammar;
import model.text.Sentence;
import model.text.Text;
import model.text.Word;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains static methods for filtering text
 */
public class RegularExpressionFilter {

    private static String firstVowelTextPattern = "\\b[AEIOUYaeiouy].*?\\b";
    private static String firstVowelWordPattern = "^[AEIOUYaeiouy].*";
    private static String firstConsonantWordPattern = "[^AEIOUYaeiouy].*?$";
    private static String twoMoreSpacesPattern = "[\\s]{2,}";
    private static String delimiterBeforePunctuationPattern = "\\b [.,?!]";
    private static String wordAfterPunctuationPattern = "[.,?!]\\b";

    /**
     * Looks for all words from text which start from vowel letter
     * @param text - string variable for filtering
     * @return Hash Set with words
     */
    public static Set<String> firstVowelText(String text){

        Matcher m = Pattern.compile(firstVowelTextPattern)
                .matcher(correctDelimiters(text));
        Set<String> words = new HashSet<>();
        while (m.find()){
//            System.out.print(m.group() + " ");
            words.add(m.group().toLowerCase());
        }
        return words;
    }

    /**
     * Looks for all words from parsed text which start from vowel letter
     * @param text - Text variable for filtering
     * @return Hash Set with words
     */
    public static Set<String> firstVowelText(Text text){
        Set<String> words = new HashSet<>();

        for (Sentence sentence: text.getText()){
            for(Grammar grammar: sentence.getSentence()){
                if (grammar instanceof Word &&
                        ((Word) grammar).getWord().matches(firstVowelWordPattern)){
                    words.add(((Word) grammar).getWord().toLowerCase());
                }
            }
        }
        return words;
    }

    /**
     * Looks for part of the word which starts from consonant letter, if there is no consonant letters
     * in word return the whole word
     * @param word - string variable for filtering
     * @return string part of the word
     */
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


    /**
     * Remove all unnecessary delimiters from the text, enters necessary one
     * after punctuation
     * @param text - string variable for correcting
     * @return string result after corrections
     */
    public static String correctDelimiters(String text){

        return removeDelimitersBeforePunctuation(
                enterSpaceAfterPunctuation(text)
        );
    }

    /**
     * Enters delimiters after punctuations if it is necessary
     * @param text - string variable for correcting
     * @return string result after corrections
     */
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

    /**
     * Removes all unnecessary delimiters before punctuations
     * @param text - string variable for correcting
     * @return string result after corrections
     */
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

    /**
     * Replace all double delimiters with single one
     * @param text - string variable for correcting
     * @return string result after corrections
     */
    public static String removeSpaces(String text){
        String result = text.trim();
        return result.replaceAll(twoMoreSpacesPattern," ");
    }

}
