package hu.imosonyi.bvtech.db.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Analysis report entity.
 *
 * @author István Mosonyi
 */
@Entity
@Table(name = "ANALYSIS_REPORT")
public class AnalysisReport implements Serializable {

    private static final long serialVersionUID = -6132509086935046976L;

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

    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((averageParagraphProcessingTime == null) 
                ? 0 : averageParagraphProcessingTime.hashCode());
        result = prime * result + ((averageParagraphSize == null) 
                ? 0 : averageParagraphSize.hashCode());
        result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((mostFrequentWord == null) ? 0 : mostFrequentWord.hashCode());
        result = prime * result + ((totalProcessingTime == null) 
                ? 0 : totalProcessingTime.hashCode());
        return result;
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AnalysisReport other = (AnalysisReport) obj;
        if (averageParagraphProcessingTime == null) {
            if (other.averageParagraphProcessingTime != null) {
                return false;
            }
        } else if (!averageParagraphProcessingTime.equals(other.averageParagraphProcessingTime)) {
            return false;
        }
        if (averageParagraphSize == null) {
            if (other.averageParagraphSize != null) {
                return false;
            }
        } else if (!averageParagraphSize.equals(other.averageParagraphSize)) {
            return false;
        }
        if (createdAt == null) {
            if (other.createdAt != null) {
                return false;
            }
        } else if (!createdAt.equals(other.createdAt)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (mostFrequentWord == null) {
            if (other.mostFrequentWord != null) {
                return false;
            }
        } else if (!mostFrequentWord.equals(other.mostFrequentWord)) {
            return false;
        }
        if (totalProcessingTime == null) {
            if (other.totalProcessingTime != null) {
                return false;
            }
        } else if (!totalProcessingTime.equals(other.totalProcessingTime)) {
            return false;
        }
        return true;
    }

}
