package hu.imosonyi.bvtech.util;

import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.model.AnalysisReport;

/**
 * Utility class to convert DTO to entity.
 *
 * @author István Mosonyi
 */
public class TextResponseToAnalysisReportConverter
        implements Converter<TextResponse, AnalysisReport> {

    @Override
    public AnalysisReport convert (TextResponse dto) {
        AnalysisReport entity = new AnalysisReport();
        entity.setAverageParagraphProcessingTime(dto.getAverageTime());
        entity.setAverageParagraphSize(dto.getAverageSize());
        entity.setMostFrequentWord(dto.getMostFrequent());
        entity.setTotalProcessingTime(dto.getTotalTime());
        return entity;
    }

    @Override
    public TextResponse revert (AnalysisReport entity) {
        TextResponse dto = new TextResponse();
        dto.setAverageTime(entity.getAverageParagraphProcessingTime());
        dto.setAverageSize(entity.getAverageParagraphSize());
        dto.setMostFrequent(entity.getMostFrequentWord());
        dto.setTotalTime(entity.getTotalProcessingTime());
        return dto;
    }

}
