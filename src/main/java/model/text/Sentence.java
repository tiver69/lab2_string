package model.text;

import java.util.LinkedList;
import java.util.List;

public class Sentence{

    private List<Grammar> sentence = new LinkedList();

    public Sentence() {
    }

    public boolean addToSentence(String sentenceItem) {
        String allPunctuation = ".,?!'\":;-()";
        if (allPunctuation.lastIndexOf(sentenceItem) != -1)
            addToSentence(new Punctuation.PunctuationBuilder(sentenceItem).build());
        else addToSentence(new Word(sentenceItem));
        return true;
    }

    public boolean addToSentence(Grammar sentenceItem) {
        return sentence.add(sentenceItem);
    }

    @Override
    public String toString() {
        StringBuilder sentenceCurrent = new StringBuilder();
        for (Grammar sentenceItem:sentence){
            sentenceCurrent.append(sentenceItem.toString());
        }
        return sentenceCurrent.toString().trim();
    }
}
