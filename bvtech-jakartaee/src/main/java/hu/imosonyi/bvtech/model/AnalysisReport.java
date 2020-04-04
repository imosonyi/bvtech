package hu.imosonyi.bvtech.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ANALYSIS_REPORT")
@NamedQuery(
        name = "AnalysisReport.findAllOrderByCreatedAtDesc",
        query = "SELECT ar FROM AnalysisReport ar ORDER BY ar.createdAt DESC"
)
public class AnalysisReport implements Serializable {

    private static final long serialVersionUID = 847966935672084028L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "MOST_FREQUENT_WORD")
    private String mostFrequentWord;

    @NotNull
    @Column(name = "AVERAGE_PARAGRAPH_SIZE")
    private Double averageParagraphSize;

    @NotNull
    @Column(name = "AVERAGE_PARAGRAPH_PROCESSING_TIME")
    private Double averageParagraphProcessingTime;

    @NotNull
    @Column(name = "TOTAL_PROCESSING_TIME")
    private Long totalProcessingTime;

    @NotNull
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedAt () {
        return createdAt;
    }

    public void setCreatedAt (LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void setCreationTime () {
        createdAt = LocalDateTime.now();
    }

}
