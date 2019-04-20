package model.text;

import model.text.Grammar;

public class Word extends Grammar {
    private String word;

    public Word(String word){
        this.word = word;
    }

    @Override
    public String toString() {
        return (" " + word);
    }
}
