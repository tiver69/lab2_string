package model.text;

import service.RegularExpressionFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Grammar {

    public static class GrammarBuilder {
        private Grammar grammar;
        private String punctuationPattern = "[.]{3}|\\p{Punct}";

        public GrammarBuilder(String toGrammar){
            Matcher m2 = Pattern.compile(punctuationPattern)
                    .matcher(RegularExpressionFilter.correctDelimiters(toGrammar));

            if (toGrammar.matches(punctuationPattern))
                grammar = new Punctuation(toGrammar);
            else
                grammar = new Word(toGrammar);
        }

        public Grammar build(){
            return grammar;
        }
    }
}
