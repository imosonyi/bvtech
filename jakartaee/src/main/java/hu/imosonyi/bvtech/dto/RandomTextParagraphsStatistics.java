package hu.imosonyi.bvtech.dto;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

public class RandomTextParagraphsStatistics implements Serializable {

    private static final long serialVersionUID = 7958839817081330838L;

    @JsonbProperty("freq_word")
    private String mostFrequentWord;

    @JsonbProperty("avg_paragraph_size")
    private Double averageParagraphSize;

    @JsonbProperty("avg_paragraph_processing_time")
    private Double averageParagraphProcessingTime;

    @JsonbProperty("total_processing_time")
    private Long totalProcessingTime;

    public String getMostFrequentWord () {
        return mostFrequentWord;
    }

    public void setMostFrequentWord (String mostFrequentWord) {
        this.mostFrequentWord = mostFrequentWord;
    }

    public Double getAverageParagraphSize () {
        return averageParagraphSize;
    }

    public void setAverageParagraphSize (Double averageParagraphSize) {
        this.averageParagraphSize = averageParagraphSize;
    }

    public Double getAverageParagraphProcessingTime () {
        return averageParagraphProcessingTime;
    }

    public void setAverageParagraphProcessingTime (Double averageParagraphProcessingTime) {
        this.averageParagraphProcessingTime = averageParagraphProcessingTime;
    }

    public Long getTotalProcessingTime () {
        return totalProcessingTime;
    }

    public void setTotalProcessingTime (Long totalProcessingTime) {
        this.totalProcessingTime = totalProcessingTime;
    }

}
