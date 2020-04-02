package hu.imosonyi.bvtech.dto;

import java.util.Map;

public class ParagraphStatistics {

    private Integer size;

    private Map<String, Integer> wordCounts;

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
