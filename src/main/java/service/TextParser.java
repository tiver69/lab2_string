package service;

import model.text.Sentence;
import model.text.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains static methods for parsing text
 */
public class TextParser {
    private static String TextParsePattern = "\\b.+?([.]{3}|[.?!])";
    private static String SentenceParsePattern = "[.]{3}|\\p{Punct}|[\\P{Punct}&&\\S]+";

    /**
     * Parse text to a sentences, divided with symbols - . ? ! ...
     * @param toParse- string variable for parsing
     * @return parsed Text variable
     */
    public static Text parseText(String toParse){
        Text.TextBuilder resultText = new Text.TextBuilder();
        Matcher m2 = Pattern.compile(TextParsePattern)
                .matcher(RegularExpressionFilter.correctDelimiters(toParse));

        while (m2.find()) {
            resultText.addToText(parseSentence(m2.group()));
//            System.out.println(m2.group());
        }
        return resultText.build();

    }

    /**
     * Parse text to a words and punctuation symbols
     * @param toParse- string variable for parsing
     * @return parsed Sentence variable
     */
    public static Sentence parseSentence(String toParse){
        Sentence.SentenceBuilder resultSentence = new Sentence.SentenceBuilder();
        Matcher m2 = Pattern.compile(SentenceParsePattern)
                .matcher(RegularExpressionFilter.correctDelimiters(toParse));

        while (m2.find()) {
            resultSentence.addToSentence(m2.group());
        }
        return resultSentence.build();
    }
}
