package model.text;

/**
 * Contains only punctuation symbols
 */
public class Punctuation extends Grammar {
    private String punctuation;

    public Punctuation(String  punctuation){
        this.punctuation = punctuation;
    }

    public String getPunctuation() {
        return punctuation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Punctuation)) return false;

        Punctuation otherWord = (Punctuation) obj;
        return punctuation.equals(otherWord.getPunctuation());
    }

    @Override
    public String toString() {
        return punctuation;
    }

}
