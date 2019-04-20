package model.text;

public class Word extends Grammar {
    private String word;

    public Word(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Word)) return false;

        Word otherWord = (Word) obj;
        return word.equals(otherWord.getWord());
    }

    @Override
    public String toString() {
        return (" " + word);
    }
}
