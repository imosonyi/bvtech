package hu.imosonyi.bvtech.dto;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

public class Statistics implements Serializable {

    private static final long serialVersionUID = 7958839817081330838L;

    @JsonbProperty("freq_word")
    private String mostFrequentWord;

    @JsonbProperty("avg_paragraph_size")
    private Integer averageParagraphSize;

    @JsonbProperty("avg_paragraph_processing_time")
    private Long averageParagraphProcessingTime;

    @JsonbProperty("total_processing_time")
    private Long totalProcessingTime;

    public String getMostFrequentWord () {
        return mostFrequentWord;
    }

    public void setMostFrequentWord (String mostFrequentWord) {
        this.mostFrequentWord = mostFrequentWord;
    }

    public Integer getAverageParagraphSize () {
        return averageParagraphSize;
    }

    public void setAverageParagraphSize (Integer averageParagraphSize) {
        this.averageParagraphSize = averageParagraphSize;
    }

    public Long getAverageParagraphProcessingTime () {
        return averageParagraphProcessingTime;
    }

    public void setAverageParagraphProcessingTime (Long averageParagraphProcessingTime) {
        this.averageParagraphProcessingTime = averageParagraphProcessingTime;
    }

    public Long getTotalProcessingTime () {
        return totalProcessingTime;
    }

    public void setTotalProcessingTime (Long totalProcessingTime) {
        this.totalProcessingTime = totalProcessingTime;
    }

}
