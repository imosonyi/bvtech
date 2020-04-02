package hu.imosonyi.bvtech.dto;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

public class TextResponse implements Serializable {

    private static final long serialVersionUID = 7958839817081330838L;

    @JsonbProperty("freq_word")
    private String mostFrequent;

    @JsonbProperty("avg_paragraph_size")
    private Double averageSize;

    @JsonbProperty("avg_paragraph_processing_time")
    private Double averageTime;

    @JsonbProperty("total_processing_time")
    private Long totalTime;

    public String getMostFrequent () {
        return mostFrequent;
    }

    public void setMostFrequent (String mostFrequentWord) {
        this.mostFrequent = mostFrequentWord;
    }

    public Double getAverageSize () {
        return averageSize;
    }

    public void setAverageSize (Double averageParagraphSize) {
        this.averageSize = averageParagraphSize;
    }

    public Double getAverageTime () {
        return averageTime;
    }

    public void setAverageTime (Double averageParagraphProcessingTime) {
        this.averageTime = averageParagraphProcessingTime;
    }

    public Long getTotalTime () {
        return totalTime;
    }

    public void setTotalTime (Long totalProcessingTime) {
        this.totalTime = totalProcessingTime;
    }

}
