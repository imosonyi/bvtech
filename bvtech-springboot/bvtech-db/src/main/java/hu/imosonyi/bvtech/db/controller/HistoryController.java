package hu.imosonyi.bvtech.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.imosonyi.bvtech.db.dto.TextResponse;
import hu.imosonyi.bvtech.db.service.HistoryService;

/**
 * Rest endpoint /betvictor/history.
 *
 * @author István Mosonyi
 */
@RestController
@RequestMapping("/betvictor")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    /**
     * Retrieves the last 10 analysis results.
     * Example request:
     * /betvictor/history
     * Example response:
     * [
     *   {
     *     "freq_word": "frequent",
     *     "avg_paragraph_size": 11.2321,
     *     "avg_paragraph_processing_time": 1.254,
     *     "total_processing_time": 3566*
     *   },
     *   ...
     * ]
     *
     * @return Last 10 analysis results.
     */
    @GetMapping("/history")
    @CrossOrigin("*")
    public ResponseEntity<List<TextResponse>> getHistory () {
        return new ResponseEntity<>(historyService.getHistory(), HttpStatus.OK);
    }

}
