package hu.imosonyi.bvtech.analyzer.dto;

import java.io.Serializable;

/**
 * Request DTO from /betvictor/text.
 *
 * @author István Mosonyi
 */
public class TextRequest implements Serializable {

    private static final long serialVersionUID = 5719371414179232408L;

    private Integer start;

    private Integer end;

    private Integer min;

    private Integer max;

    /**
     * TODO.
     * @param start TODO.
     * @param end TODO.
     * @param min TODO.
     * @param max TODO.
     */
    public TextRequest (Integer start, Integer end, Integer min, Integer max) {
        this.start = start;
        this.end = end;
        this.min = min;
        this.max = max;
    }

    public Integer getStart () {
        return start;
    }

    public void setStart (Integer start) {
        this.start = start;
    }

    public Integer getEnd () {
        return end;
    }

    public void setEnd (Integer end) {
        this.end = end;
    }

    public Integer getMin () {
        return min;
    }

    public void setMin (Integer min) {
        this.min = min;
    }

    public Integer getMax () {
        return max;
    }

    public void setMax (Integer max) {
        this.max = max;
    }

}
