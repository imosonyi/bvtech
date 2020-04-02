package hu.imosonyi.bvtech.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.rest.TextRest;
import hu.imosonyi.bvtech.service.TextService;

@RequestScoped
public class TextRestImpl implements TextRest {

    @Inject
    private TextService textService;

    @Override
    public Response getText (TextRequest textRequest) {
        return Response
                .ok()
                .entity(textService.getStatistics(textRequest))
                .build();
    }

}
