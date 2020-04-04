package hu.imosonyi.bvtech.service;

import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;

/**
 * Service layer for handling the requests coming in /betvictor/text.
 *
 * @author István Mosonyi
 */
public interface TextService {

    /**
     * Delegates the analysis calculation to {@link ApiService} and stores the
     * result in the database.
     *
     * @param textRequest The /betvictor/text request to analyse.
     * @return Analysis report of the paragraphs.
     */
    TextResponse getStatistics (TextRequest textRequest);

}
