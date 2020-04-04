package hu.imosonyi.bvtech.service;

import java.util.List;

import hu.imosonyi.bvtech.dto.TextResponse;

/**
 * Service layer for handling the requests coming in /betvictor/history.
 *
 * @author István Mosonyi
 */
public interface HistoryService {

    /**
     * Retrieves the last 10 analysis results.
     *
     * @return Last 10 analysis results.
     */
    List<TextResponse> getHistory ();

}
