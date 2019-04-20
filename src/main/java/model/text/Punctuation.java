package model.text;

public class Punctuation extends Grammar {
    private String punctuation;

    private Punctuation(PunctuationBuilder builder){
        this.punctuation = builder.punctuation;
    }

    @Override
    public String toString() {
        return punctuation;
    }

    public static class PunctuationBuilder {
        private String punctuation;
        private String allPunctuation = ".,?!'\":;-()";

        public PunctuationBuilder(String punctuation){
            if (allPunctuation.lastIndexOf(punctuation) != -1)
                this.punctuation = punctuation;
            else throw new IllegalArgumentException("Symbol is not a punctuation!");
        }

        public Punctuation build(){
            return new Punctuation(this);
        }

    }
}
