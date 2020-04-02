package hu.imosonyi.bvtech.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.model.AnalysisReport;

public class TextResponseToAnalysisReportConverterTest {

    private TextResponseToAnalysisReportConverter converter = new TextResponseToAnalysisReportConverter();

    @Test
    public void testConvert () {
        TextResponse dto = new TextResponse();
        dto.setAverageSize(1.0);
        dto.setAverageTime(1.0);
        dto.setMostFrequent("word");
        dto.setTotalTime(1L);

        AnalysisReport result = converter.convert(dto);
        assertThat(result.getAverageParagraphSize(), is(equalTo(dto.getAverageSize())));
        assertThat(result.getAverageParagraphProcessingTime(), is(equalTo(dto.getAverageTime())));
        assertThat(result.getMostFrequentWord(), is(equalTo(dto.getMostFrequent())));
        assertThat(result.getTotalProcessingTime(), is(equalTo(dto.getTotalTime())));
    }

    @Test
    public void testRevert () {
        AnalysisReport entity = new AnalysisReport();
        entity.setAverageParagraphSize(1.0);
        entity.setAverageParagraphProcessingTime(1.0);
        entity.setMostFrequentWord("word");
        entity.setTotalProcessingTime(1L);

        TextResponse result = converter.revert(entity);
        assertThat(result.getAverageSize(), is(equalTo(entity.getAverageParagraphSize())));
        assertThat(result.getAverageTime(), is(equalTo(entity.getAverageParagraphProcessingTime())));
        assertThat(result.getMostFrequent(), is(equalTo(entity.getMostFrequentWord())));
        assertThat(result.getTotalTime(), is(equalTo(entity.getTotalProcessingTime())));
    }

}
