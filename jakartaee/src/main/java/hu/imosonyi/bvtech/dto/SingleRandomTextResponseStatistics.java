package hu.imosonyi.bvtech.dto;

import java.util.List;
import java.util.Map;

public class SingleRandomTextResponseStatistics {

    private Map<String, Integer> wordCounts;

    private List<Integer> paragraphSizes;

    private Long paragraphProcessingTime;

    public Map<String, Integer> getWordCounts () {
        return wordCounts;
    }

    public void setWordCounts (Map<String, Integer> wordCounts) {
        this.wordCounts = wordCounts;
    }

    public List<Integer> getParagraphSizes () {
        return paragraphSizes;
    }

    public void setParagraphSizes (List<Integer> paragraphSizes) {
        this.paragraphSizes = paragraphSizes;
    }

    public Long getParagraphProcessingTime () {
        return paragraphProcessingTime;
    }

    public void setParagraphProcessingTime (Long paragraphProcessingTime) {
        this.paragraphProcessingTime = paragraphProcessingTime;
    }

}
