package service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;

public class RegularExpressionFilterTest {

    public static String firstVowelText = "   Apple, fruit .available ?Phone... Yes    good idea?";
    public static String correctDelimitersExpectedResult = "Apple, fruit. available? Phone... Yes good idea?";
    public static Set<String> firstVowelExpectedResult = new HashSet<>();
    public static Set<String> firstConsonantWords = new HashSet<>();
    public static Set<String> firstConsonantExpectedResult = new HashSet<>();

    @BeforeClass
    public static void setUpClass(){
        firstVowelExpectedResult.add("apple");
        firstVowelExpectedResult.add("available");
        firstVowelExpectedResult.add("yes");
        firstVowelExpectedResult.add("idea");

        firstConsonantWords.addAll(firstVowelExpectedResult);
        firstConsonantExpectedResult.add("pple");
        firstConsonantExpectedResult.add("vailable");
        firstConsonantExpectedResult.add("s");
        firstConsonantExpectedResult.add("dea");
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
        System.out.println(testResult);
        System.out.println(correctDelimitersExpectedResult);
        Assert.assertThat("String must be equal",
                testResult, equalTo(correctDelimitersExpectedResult));
    }
}