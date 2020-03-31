package hu.imosonyi.bvtech.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import hu.imosonyi.bvtech.rest.TextRest;

@RequestScoped
public class TextRestImpl implements TextRest {

    @Override
    public Response getTextTest () {
        return Response.ok().entity("Hello, World!").build();
    }

}
