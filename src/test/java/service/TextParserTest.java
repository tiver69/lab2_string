package service;

import model.text.Sentence;
import model.text.Text;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class TextParserTest {

    public static String text = "   afurfh, a .uehbveo ?trwger... sdfcjn    we en?";
    public static String sentence = "   afurfh, a .";;
    public static Text expectedTextParse;
    public static Sentence expectedSentenceParse;

    @BeforeClass
    public static void setUpClass(){
        expectedSentenceParse = new Sentence.SentenceBuilder()
                .addToSentence("afurfh")
                .addToSentence(",")
                .addToSentence("a")
                .addToSentence(".")
                .build();
        Sentence sentence2 = new Sentence.SentenceBuilder()
                .addToSentence("uehbveo")
                .addToSentence("?")
                .build();
        Sentence sentence3 = new Sentence.SentenceBuilder()
                .addToSentence("trwger")
                .addToSentence("...")
                .build();
        Sentence sentence4 = new Sentence.SentenceBuilder()
                .addToSentence("sdfcjn")
                .addToSentence("we")
                .addToSentence("en")
                .addToSentence("?")
                .build();
        expectedTextParse = new Text.TextBuilder()
                .addToSentence(expectedSentenceParse)
                .addToSentence(sentence2)
                .addToSentence(sentence3)
                .addToSentence(sentence4)
                .build();
    }

    @Test
    public void parseText() {
        Text resultParse = TextParser.parseText(text);
//        System.out.println(resultParse);
        Assert.assertThat("Text must be equals",
                resultParse, equalTo(expectedTextParse));
    }

    @Test
    public void parseSentenceTest() {
        Sentence resultParse = TextParser.parseSentence(sentence);
//        System.out.println(resultParse);
        Assert.assertThat("Text must be equals",
                resultParse, equalTo(expectedSentenceParse));
    }
}