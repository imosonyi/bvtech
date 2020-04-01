package hu.imosonyi.bvtech.service.impl;

import javax.enterprise.context.RequestScoped;

import hu.imosonyi.bvtech.dto.ParagraphGenerationInfo;
import hu.imosonyi.bvtech.dto.RandomParagraphsStatistics;
import hu.imosonyi.bvtech.service.TextService;

@RequestScoped
public class TextServiceImpl implements TextService {

    @Override
    public RandomParagraphsStatistics getRandomParagraphsStatistics (
            ParagraphGenerationInfo paragraphGenerationInfo) {
        final long totalProcessingStart = System.currentTimeMillis();
        RandomParagraphsStatistics statistics = mockStatistics();
        final long totalProcessingEnd = System.currentTimeMillis();
        statistics.setTotalProcessingTime(totalProcessingEnd - totalProcessingStart);
        return statistics;
    }

    private RandomParagraphsStatistics mockStatistics () {
        RandomParagraphsStatistics statistics = new RandomParagraphsStatistics();
        statistics.setAverageParagraphProcessingTime(5.0);
        statistics.setAverageParagraphSize(5.0);
        statistics.setMostFrequentWord("frequent");
        statistics.setTotalProcessingTime(10L);
        return statistics;
    }

}
