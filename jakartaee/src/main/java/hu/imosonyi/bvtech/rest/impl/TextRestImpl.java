package hu.imosonyi.bvtech.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import hu.imosonyi.bvtech.dto.ParagraphInfo;
import hu.imosonyi.bvtech.dto.Statistics;
import hu.imosonyi.bvtech.rest.TextRest;

@RequestScoped
public class TextRestImpl implements TextRest {

    @Override
    public Response getTextTest (ParagraphInfo paragraphInfo) {
        return Response.ok().entity(generateDummyResponse()).build();
    }
    
    private Statistics generateDummyResponse() {
        Statistics statistics = new Statistics();
        statistics.setMostFrequentWord("Frequent");
        statistics.setAverageParagraphProcessingTime(15L);
        statistics.setAverageParagraphSize(7);
        statistics.setTotalProcessingTime(75L);
        return statistics;
    }

}
