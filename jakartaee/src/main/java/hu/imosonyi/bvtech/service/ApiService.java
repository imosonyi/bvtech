package hu.imosonyi.bvtech.service;

import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;

/**
 * Service layer for handling the RandomText API.
 *
 * @author István Mosonyi
 */
public interface ApiService {

    /**
     * Creates the analysis report for the /betvictor/text request.
     *
     * @param textRequest The /betvictor/text request to analyse.
     * @return Analysis report of the paragraphs.
     */
    TextResponse analyze (TextRequest textRequest);

}
