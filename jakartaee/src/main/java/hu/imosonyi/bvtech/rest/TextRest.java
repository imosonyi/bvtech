package hu.imosonyi.bvtech.rest;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import hu.imosonyi.bvtech.dto.TextRequest;

/**
 * Rest endpoint /betvictor/text.
 *
 * @author István Mosonyi
 */
@Path("/text")
public interface TextRest {

    /**
     * Makes all the necessary requests to the RandomText API and analyzes the
     * the responses. It is going to make a request for every
     * p_start <= p <= p_end with the specified word count min and max.
     * Example request:
     * /betvictor/text?p_start=1&p_end=100&w_count_min=1&w_count_max=25
     * Example response:
     * {
     *   "freq_word": "frequent",
     *   "avg_paragraph_size": 11.2321,
     *   "avg_paragraph_processing_time": 1.254,
     *   "total_processing_time": 3566*
     * }
     *
     * @param textRequest How many and how long paragraphs should the
     *                    application analyse.
     * @return Analysis results.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getText (@BeanParam TextRequest textRequest);

}
