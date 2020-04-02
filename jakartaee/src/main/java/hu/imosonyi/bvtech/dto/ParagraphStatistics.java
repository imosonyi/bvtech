package hu.imosonyi.bvtech.dto;

import java.util.Map;

/**
 * Temporary DTO to store the analysis result for later calculations.
 *
 * @author István Mosonyi
 */
public class ParagraphStatistics {

    /**
     * Size of the paragraph (word count).
     */
    private Integer size;

    /**
     * A key value pair of the words in the paragraph and how many times they
     * have been used in this paragraph.
     */
    private Map<String, Integer> wordCounts;

    /**
     * Processing time of a single paragraph in milliseconds.
     */
    private Long processingTime;

    public Integer getSize () {
        return size;
    }

    public void setSize (Integer size) {
        this.size = size;
    }

    public Map<String, Integer> getWordCounts () {
        return wordCounts;
    }

    public void setWordCounts (Map<String, Integer> wordCounts) {
        this.wordCounts = wordCounts;
    }

    public Long getProcessingTime () {
        return processingTime;
    }

    public void setProcessingTime (Long processingTime) {
        this.processingTime = processingTime;
    }

}
