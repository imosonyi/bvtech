package hu.imosonyi.bvtech.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

public class ParagraphInfo implements Serializable {

    private static final long serialVersionUID = -7418272506521585255L;

    @NotNull
    @QueryParam("p_start")
    private Integer paragraphStart;

    @NotNull
    @QueryParam("p_end")
    private Integer paragraphEnd;

    @NotNull
    @QueryParam("w_count_min")
    private Integer wordCountMin;

    @NotNull
    @QueryParam("w_count_max")
    private Integer wordCountMax;

    public Integer getParagraphStart () {
        return paragraphStart;
    }

    public void setParagraphStart (Integer paragraphStart) {
        this.paragraphStart = paragraphStart;
    }

    public Integer getParagraphEnd () {
        return paragraphEnd;
    }

    public void setParagraphEnd (Integer paragraphEnd) {
        this.paragraphEnd = paragraphEnd;
    }

    public Integer getWordCountMin () {
        return wordCountMin;
    }

    public void setWordCountMin (Integer wordCountMin) {
        this.wordCountMin = wordCountMin;
    }

    public Integer getWordCountMax () {
        return wordCountMax;
    }

    public void setWordCountMax (Integer wordCountMax) {
        this.wordCountMax = wordCountMax;
    }

    @Override
    public String toString () {
        return "ParagraphInfo [paragraphStart=" + paragraphStart + ", paragraphEnd="
                + paragraphEnd + ", wordCountMin="
                + wordCountMin + ", wordCountMax=" + wordCountMax + "]";
    }

}
