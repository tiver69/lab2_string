package model.text;

import java.util.LinkedList;
import java.util.List;

public class Text {
    private List<Sentence> text = new LinkedList();

    public Text(){
    }

    public Text(TextBuilder builder) {
        text.addAll(builder.text);
    }

    public List<Sentence> getText() {
        return new LinkedList<>(text);
    }

    public void addToText(Sentence sentence) {
        text.add(sentence);
    }

    @Override
    public String toString() {
        StringBuilder sentenceCurrent = new StringBuilder();
        for (Sentence sentence: text){
            sentenceCurrent.append(sentence.toString()).append(" ");
        }
        return sentenceCurrent.toString().trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Text)) return false;

        Text otherText = (Text) obj;
        return text.equals(otherText.getText());
    }

    public static class TextBuilder {
        private List<Sentence> text = new LinkedList();

        public TextBuilder addToSentence(Sentence sentence) {
            text.add(sentence);
            return this;
        }

        public Text build(){
            return new Text(this);
        }
    }

}
