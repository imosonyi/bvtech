package hu.imosonyi.bvtech.analysis;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import hu.imosonyi.bvtech.analysis.impl.SingleParagraphAnalyzerImpl;
import hu.imosonyi.bvtech.dto.SingleParagraphStatistics;

@RunWith(MockitoJUnitRunner.class)
public class SingleParagraphAnalyserTest {
    
    @InjectMocks
    private SingleParagraphAnalyzer singleParagraphAnalyzer = new SingleParagraphAnalyzerImpl();
    
    @Test
    public void testAnalyzeShouldReturnCorrectSize () {
        String input = "<p>This is a test paragraph.</p>";
        
        SingleParagraphStatistics result = singleParagraphAnalyzer.analyze(input);
        
        assertThat(result.getSize(), is(equalTo(5)));
    }
    
    @Test
    public void testAnalyzeShouldReturnCorrectWordCount () {
        String input = "<p>The test word should be counted twice in this test.</p>";
        
        SingleParagraphStatistics result = singleParagraphAnalyzer.analyze(input);
        
        Map<String, Integer> expected = new HashMap<>();
        expected.put("The", 1);
        expected.put("test", 2);
        expected.put("word", 1);
        expected.put("should", 1);
        expected.put("be", 1);
        expected.put("counted", 1);
        expected.put("twice", 1);
        expected.put("in", 1);
        expected.put("this", 1);
        assertThat(result.getWordCounts().entrySet(), everyItem(is(in(expected.entrySet()))));
        assertThat(expected.entrySet(), everyItem(is(in(result.getWordCounts().entrySet()))));
    }

}
