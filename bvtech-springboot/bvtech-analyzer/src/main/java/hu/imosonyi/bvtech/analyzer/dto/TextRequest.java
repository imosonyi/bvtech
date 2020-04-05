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
     * Constructor.
     *
     * @param start Start number of paragraphs.
     * @param end Last number of paragraphs.
     * @param min Minimum word count in paragraphs.
     * @param max Maximum word count in paragraphs.
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

    @Override
    public int hashCode () {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        result = prime * result + ((max == null) ? 0 : max.hashCode());
        result = prime * result + ((min == null) ? 0 : min.hashCode());
        result = prime * result + ((start == null) ? 0 : start.hashCode());
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
        TextRequest other = (TextRequest) obj;
        if (end == null) {
            if (other.end != null) {
                return false;
            }
        } else if (!end.equals(other.end)) {
            return false;
        }
        if (max == null) {
            if (other.max != null) {
                return false;
            }
        } else if (!max.equals(other.max)) {
            return false;
        }
        if (min == null) {
            if (other.min != null) {
                return false;
            }
        } else if (!min.equals(other.min)) {
            return false;
        }
        if (start == null) {
            if (other.start != null) {
                return false;
            }
        } else if (!start.equals(other.start)) {
            return false;
        }
        return true;

    }

}
