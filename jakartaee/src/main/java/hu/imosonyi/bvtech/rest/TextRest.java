package hu.imosonyi.bvtech.rest;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import hu.imosonyi.bvtech.dto.ParagraphGenerationInfo;

@Path("/text")
public interface TextRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response getText (@BeanParam ParagraphGenerationInfo paragraphInfo);

}
