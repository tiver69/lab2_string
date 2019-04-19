package service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionFilter {

    public static Set<String> firstVowel (String text){
        String pattern01 = "\\b[AEIOUYaeiouy].+?\\b";

        Matcher m = Pattern.compile(pattern01).matcher(text);
        Set<String> words = new HashSet<String>();
        while (m.find()){
            System.out.print(m.group() + "-");
            words.add(m.group());
        }
        return words;
    }
}
