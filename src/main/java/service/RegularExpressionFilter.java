package service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionFilter {

    private static String firstVowelTextPattern = "\\b[AEIOUYaeiouy].+?\\b";
    private static String firstConsonantWordPattern = "[^AEIOUYaeiouy].+?$";

    public static Set<String> firstVowelText(String text){

        Matcher m = Pattern.compile(firstVowelTextPattern).matcher(text);
        Set<String> words = new HashSet<String>();
        while (m.find()){
//            System.out.print(m.group() + "-");
            words.add(m.group());
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
        else return "";
    }

}
