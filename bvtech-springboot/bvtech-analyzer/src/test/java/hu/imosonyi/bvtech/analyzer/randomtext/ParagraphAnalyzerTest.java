package hu.imosonyi.bvtech.analyzer.randomtext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParagraphAnalyzerTest {

    @MockBean
    private TextResponseCalculator calculator;
    
    @Autowired
    private ParagraphAnalyzer paragraphAnalyzer;

    @Test
    public void testAnalyzeShouldCallCalculatorWithSize () {
        String paragraph = "<p>This is a test paragraph.</p>";

        paragraphAnalyzer.analyze(paragraph);

        verify(calculator, times(1)).addSize(5);
    }
    
    @Test
    public void testAnalyzeShouldCallCalculatorWithTime () {
        String paragraph = "<p>This is a test paragraph.</p>";

        paragraphAnalyzer.analyze(paragraph);

        verify(calculator, times(1)).addTime(any());
    }
    
    @Test
    public void testAnalyzeShouldCallCalculatorWithWord () {
        String paragraph = "<p>This is a test paragraph.</p>";

        paragraphAnalyzer.analyze(paragraph);

        verify(calculator, times(1)).addWord("This");
        verify(calculator, times(1)).addWord("is");
        verify(calculator, times(1)).addWord("a");
        verify(calculator, times(1)).addWord("test");
        verify(calculator, times(1)).addWord("paragraph");
    }

}
