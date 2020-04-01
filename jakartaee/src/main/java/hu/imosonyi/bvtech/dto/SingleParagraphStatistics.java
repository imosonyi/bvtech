package hu.imosonyi.bvtech.dto;

import java.util.Map;

public class SingleParagraphStatistics {

    private Map<String, Integer> wordCounts;

    private Integer size;
    
    public SingleParagraphStatistics (Map<String, Integer> wordCounts, Integer size) {
        this.wordCounts = wordCounts;
        this.size = size;
    }

    public Map<String, Integer> getWordCounts () {
        return wordCounts;
    }

    public void setWordCounts (Map<String, Integer> wordCounts) {
        this.wordCounts = wordCounts;
    }

    public Integer getSize () {
        return size;
    }

    public void setSize (Integer size) {
        this.size = size;
    }
    
}
