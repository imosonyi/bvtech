package hu.imosonyi.bvtech.analysis;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import hu.imosonyi.bvtech.analysis.impl.SingleParagraphAnalyzerImpl;
import hu.imosonyi.bvtech.analysis.impl.SingleRandomTextResponseAnalyzerImpl;
import hu.imosonyi.bvtech.dto.RandomTextResponse;
import hu.imosonyi.bvtech.dto.SingleRandomTextRequestStatistics;

@RunWith(MockitoJUnitRunner.class)
public class SingleRandomTextResponseAnalyserTest {
    
    @Spy
    private SingleParagraphAnalyzer singleParagraphAnalyzer = new SingleParagraphAnalyzerImpl();
    
    @InjectMocks
    private SingleRandomTextResponseAnalyzer singleRandomTextResponseAnalyzer = new SingleRandomTextResponseAnalyzerImpl();
    
    @Test
    public void testAnalyzeShouldNotSetProcessingTime () {
        String paragraphs = "<p>Generated paragraph.</p>\r";
        RandomTextResponse input = new RandomTextResponse();
        input.setGeneratedParagraphs(paragraphs);
        
        SingleRandomTextRequestStatistics result = singleRandomTextResponseAnalyzer.analyze(input);
        
        assertThat(result.getParagraphProcessingTime(), is(nullValue()));
    }
    
    @Test
    public void testAnalyzeShouldReturnCorrectParagraphSizes () {
        String paragraphs = "<p>Generated paragraph.</p>\r<p>A longer paragraph.</p>\r<p>And an even longer paragraph.</p>\r";
        RandomTextResponse input = new RandomTextResponse();
        input.setGeneratedParagraphs(paragraphs);
        
        SingleRandomTextRequestStatistics result = singleRandomTextResponseAnalyzer.analyze(input);
        
        List<Integer> expected = Arrays.asList(2, 3, 5);
        assertThat(result.getParagraphSizes(), everyItem(is(in(expected))));
        assertThat(expected, everyItem(is(in(result.getParagraphSizes()))));
    }
    
    @Test
    public void testAnalyzeShouldReturnCorrectWordCounts () {
        String paragraphs = "<p>Generated paragraph.</p>\r<p>Another paragraph.</p>\r";
        RandomTextResponse input = new RandomTextResponse();
        input.setGeneratedParagraphs(paragraphs);
        
        SingleRandomTextRequestStatistics result = singleRandomTextResponseAnalyzer.analyze(input);
        
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Generated", 1);
        expected.put("paragraph", 2);
        expected.put("Another", 1);
        assertThat(result.getWordCounts().entrySet(), everyItem(is(in(expected.entrySet()))));
        assertThat(expected.entrySet(), everyItem(is(in(result.getWordCounts().entrySet()))));
    }

}
