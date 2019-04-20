package model.text;

import model.text.Sentence;

import java.util.LinkedList;
import java.util.List;

public class Text {

    private List<Sentence> text = new LinkedList();

    public Text() {
    }

    public boolean addToText(Sentence sentence) {
        text.add(sentence);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sentenceCurrent = new StringBuilder();
        for (Sentence sentence: text){
            sentenceCurrent.append(sentence.toString()).append(" ");
        }
        return sentenceCurrent.toString().trim();
    }
}
