package hu.imosonyi.bvtech.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Rest endpoint /betvictor/history.
 *
 * @author István Mosonyi
 */
@Path("/history")
public interface HistoryRest {

    /**
     * Retrieves the last 10 analysis results.
     * Example request:
     * /betvictor/history
     * Example response:
     * [
     *   {
     *     "freq_word": "frequent",
     *     "avg_paragraph_size": 11.2321,
     *     "avg_paragraph_processing_time": 1.254,
     *     "total_processing_time": 3566*
     *   },
     *   ...
     * ]
     *
     * @return Last 10 analysis results.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getHistory ();

}
