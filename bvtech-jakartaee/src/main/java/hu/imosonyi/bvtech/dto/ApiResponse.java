package hu.imosonyi.bvtech.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response from RandomText API.
 *
 * @author István Mosonyi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = -8897356299437865124L;

    @JsonProperty("text_out")
    private String generatedParagraphs;

    public String getGeneratedParagraphs () {
        return generatedParagraphs;
    }

    public void setGeneratedParagraphs (String generatedParagraphs) {
        this.generatedParagraphs = generatedParagraphs;
    }

}
