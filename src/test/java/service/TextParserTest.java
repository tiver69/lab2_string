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

    public static String text = "   Hello, hello .Ok ?Tired... How    are you?";
    public static String sentence = "   Hello, hello .";;
    public static Text expectedTextParse;
    public static Sentence expectedSentenceParse;

    @BeforeClass
    public static void setUpClass(){
        expectedSentenceParse = new Sentence.SentenceBuilder()
                .addToSentence("Hello")
                .addToSentence(",")
                .addToSentence("hello")
                .addToSentence(".")
                .build();
        Sentence sentence2 = new Sentence.SentenceBuilder()
                .addToSentence("Ok")
                .addToSentence("?")
                .build();
        Sentence sentence3 = new Sentence.SentenceBuilder()
                .addToSentence("Tired")
                .addToSentence("...")
                .build();
        Sentence sentence4 = new Sentence.SentenceBuilder()
                .addToSentence("How")
                .addToSentence("are")
                .addToSentence("you")
                .addToSentence("?")
                .build();
        expectedTextParse = new Text.TextBuilder()
                .addToText(expectedSentenceParse)
                .addToText(sentence2)
                .addToText(sentence3)
                .addToText(sentence4)
                .build();
    }

    @Test
    public void parseText() {
        Text resultParse = TextParser.parseText(text);
        System.out.println(resultParse);
        Assert.assertThat("Text must be equals",
                resultParse, equalTo(expectedTextParse));
    }

    @Test
    public void parseSentenceTest() {
        Sentence resultParse = TextParser.parseSentence(sentence);
        System.out.println(resultParse);
        Assert.assertThat("Sentence must be equals",
                resultParse, equalTo(expectedSentenceParse));
    }
}