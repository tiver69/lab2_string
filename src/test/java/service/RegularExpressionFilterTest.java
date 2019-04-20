package service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegularExpressionFilterTest {

    public static String firstVowelText = "   afurfh, a .,uehbveo ?trwger... sdfcjn    we en???";
    public static Set<String> firstVowelExpectedResult = new HashSet<>();
    public static Set<String> firstConsonantWords = new HashSet<>();
    public static Set<String> firstConsonantExpectedResult = new HashSet<>();

    @BeforeClass
    public static void setUpClass(){
        firstVowelExpectedResult.add("afurfh");
        firstVowelExpectedResult.add("uehbveo");
        firstVowelExpectedResult.add("en");
        firstVowelExpectedResult.add("a");

        firstConsonantWords.addAll(firstVowelExpectedResult);
        firstConsonantExpectedResult.add("furfh");
        firstConsonantExpectedResult.add("hbveo");
        firstConsonantExpectedResult.add("n");
        firstConsonantExpectedResult.add("a");
    }

    @Test
    public void firstVowelTextTest() {
        Set<String> testResult = RegularExpressionFilter.
                firstVowelText(firstVowelText);
        System.out.println(firstVowelExpectedResult);
        System.out.println(testResult);
        Assert.assertThat("Result sets must be equal",
                testResult, equalTo(firstVowelExpectedResult));
    }

    @Test
    public void firstConsonantWordTest() {
        Set<String> testResult = new HashSet<>();
        for (String word : firstConsonantWords) {
            testResult.add(RegularExpressionFilter.firstConsonantWord(word));
        }
        System.out.println(firstConsonantExpectedResult);
        System.out.println(testResult);
        Assert.assertThat("Result sets must be equal",
                testResult, equalTo(firstConsonantExpectedResult));
    }

    @Test
    public void correctDelimitersTest() {
        String testResult = RegularExpressionFilter.correctDelimiters(firstVowelText);
        String correctDelimitersExpectedResult = "afurfh, a., uehbveo? trwger... sdfcjn we en???";
        System.out.println(testResult);
        System.out.println(correctDelimitersExpectedResult);
        Assert.assertThat("String must be equal",
                testResult, equalTo(correctDelimitersExpectedResult));
    }
}