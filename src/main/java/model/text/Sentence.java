package model.text;

import java.util.LinkedList;
import java.util.List;

public class Sentence{

    private List<Grammar> sentence = new LinkedList();

    public Sentence(){
    }

    public Sentence(SentenceBuilder builder) {
        this.sentence.addAll(builder.sentence);
    }

    public List<Grammar> getSentence() {
        return new LinkedList<>(sentence);
    }

    public boolean addToSentence(String sentenceItem) {
        return sentence.add(
                new Grammar.GrammarBuilder(sentenceItem)
                        .build());
    }

    public boolean addToSentence(Grammar sentenceItem) {
        return sentence.add(sentenceItem);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Sentence)) return false;

        Sentence otherSentence = (Sentence) obj;
        return sentence.equals(otherSentence.getSentence());
    }

    @Override
    public String toString() {
        StringBuilder sentenceCurrent = new StringBuilder();
        for (Grammar sentenceItem:sentence){
            sentenceCurrent.append(sentenceItem.toString());
        }
        return sentenceCurrent.toString().trim();
    }

    public static class SentenceBuilder {
        private List<Grammar> sentence = new LinkedList();

        public SentenceBuilder addToSentence(String sentenceItem) {
            sentence.add(
                    new Grammar.GrammarBuilder(sentenceItem)
                            .build());
            return this;
        }

        public SentenceBuilder addToSentence(Grammar sentenceItem) {
            sentence.add(sentenceItem);
            return this;
        }

        public Sentence build(){
            return new Sentence(this);
        }
    }
}
