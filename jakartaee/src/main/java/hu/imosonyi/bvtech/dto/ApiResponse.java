package hu.imosonyi.bvtech.dto;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;

public class ApiResponse implements Serializable {

    private static final long serialVersionUID = -8897356299437865124L;

    @JsonbProperty("type")
    private String type;

    @JsonbProperty("amount")
    private Integer numberOfParagraphs;

    @JsonbProperty("number")
    private Integer minNumberOfWords;

    @JsonbProperty("number_max")
    private Integer maxNumberOfWords;

    @JsonbProperty("format")
    private String format;

    @JsonbProperty("time")
    private String time;

    @JsonbProperty("text_out")
    private String generatedParagraphs;

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public Integer getNumberOfParagraphs () {
        return numberOfParagraphs;
    }

    public void setNumberOfParagraphs (Integer numberOfParagraphs) {
        this.numberOfParagraphs = numberOfParagraphs;
    }

    public Integer getMinNumberOfWords () {
        return minNumberOfWords;
    }

    public void setMinNumberOfWords (Integer minNumberOfWords) {
        this.minNumberOfWords = minNumberOfWords;
    }

    public Integer getMaxNumberOfWords () {
        return maxNumberOfWords;
    }

    public void setMaxNumberOfWords (Integer maxNumberOfWords) {
        this.maxNumberOfWords = maxNumberOfWords;
    }

    public String getFormat () {
        return format;
    }

    public void setFormat (String format) {
        this.format = format;
    }

    public String getTime () {
        return time;
    }

    public void setTime (String time) {
        this.time = time;
    }

    public String getGeneratedParagraphs () {
        return generatedParagraphs;
    }

    public void setGeneratedParagraphs (String generatedParagraphs) {
        this.generatedParagraphs = generatedParagraphs;
    }

}
