package hu.imosonyi.bvtech.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;

/**
 * Request DTO from /betvictor/text.
 *
 * @author István Mosonyi
 */
public class TextRequest implements Serializable {

    private static final long serialVersionUID = -7418272506521585255L;

    @NotNull
    @QueryParam("p_start")
    private Integer start;

    @NotNull
    @QueryParam("p_end")
    private Integer end;

    @NotNull
    @QueryParam("w_count_min")
    private Integer min;

    @NotNull
    @QueryParam("w_count_max")
    private Integer max;

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
