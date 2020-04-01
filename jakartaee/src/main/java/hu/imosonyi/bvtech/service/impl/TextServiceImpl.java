package hu.imosonyi.bvtech.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import hu.imosonyi.bvtech.dto.ParagraphGenerationInfo;
import hu.imosonyi.bvtech.dto.RandomTextParagraphsStatistics;
import hu.imosonyi.bvtech.service.TextService;

@RequestScoped
public class TextServiceImpl implements TextService {

    private Client client = ClientBuilder.newClient();
    
    @Override
    public RandomTextParagraphsStatistics getRandomParagraphsStatistics (
            ParagraphGenerationInfo paragraphGenerationInfo) {
        final long totalProcessingStart = System.currentTimeMillis();
        RandomTextParagraphsStatistics statistics = mockStatistics();
        final long totalProcessingEnd = System.currentTimeMillis();
        statistics.setTotalProcessingTime(totalProcessingEnd - totalProcessingStart);
        return statistics;
    }

    private RandomTextParagraphsStatistics mockStatistics () {
        RandomTextParagraphsStatistics statistics = new RandomTextParagraphsStatistics();
        statistics.setAverageParagraphProcessingTime(5.0);
        statistics.setAverageParagraphSize(5.0);
        statistics.setMostFrequentWord("frequent");
        return statistics;
    }

}
