package hu.imosonyi.bvtech.randomtext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import hu.imosonyi.bvtech.dto.ParagraphStatistics;

public class ParagraphAnalyzerTest {

    @Test
    public void testAnalyzerShouldSetProcessingTime () {
        String paragraph = "<p>This is a test paragraph.</p>";

        ParagraphStatistics result = new ParagraphAnalyzer(paragraph).getStatistics();

        assertThat(result.getProcessingTime(), is(not(nullValue())));
    }

    @Test
    public void testAnalyzerShouldCalculateSize () {
        String paragraph = "<p>This is a test paragraph.</p>";

        ParagraphStatistics result = new ParagraphAnalyzer(paragraph).getStatistics();

        assertThat(result.getSize(), is(equalTo(5)));
    }

    @Test
    public void testAnalyzerShouldCalculateWordCounts () {
        String paragraph = "<p>The word this and test should be counted twice in this test.</p>";

        ParagraphStatistics result = new ParagraphAnalyzer(paragraph).getStatistics();

        Map<String, Integer> expected = new HashMap<>();
        expected.put("The", 1);
        expected.put("word", 1);
        expected.put("this", 2);
        expected.put("and", 1);
        expected.put("test", 2);
        expected.put("should", 1);
        expected.put("be", 1);
        expected.put("counted", 1);
        expected.put("twice", 1);
        expected.put("in", 1);
        assertThat(result.getWordCounts().entrySet(), everyItem(is(in(expected.entrySet()))));
        assertThat(expected.entrySet(), everyItem(is(in(result.getWordCounts().entrySet()))));
    }

    @Test
    public void testAnalyzerShouldTrimHtml () {
        String paragraph = "<p>This is a test paragraph.</p>";

        ParagraphStatistics result = new ParagraphAnalyzer(paragraph).getStatistics();

        assertThat(result.getWordCounts().keySet(), everyItem(is(not(containsString("<p>")))));
        assertThat(result.getWordCounts().keySet(), everyItem(is(not(containsString("</p>")))));
    }

}
