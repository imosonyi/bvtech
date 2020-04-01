package hu.imosonyi.bvtech.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import hu.imosonyi.bvtech.dto.ParagraphGenerationInfo;
import hu.imosonyi.bvtech.rest.TextRest;
import hu.imosonyi.bvtech.service.TextService;

@RequestScoped
public class TextRestImpl implements TextRest {

    @Inject
    private TextService textService;

    @Override
    public Response getText (ParagraphGenerationInfo paragraphGenerationInfo) {
        return Response
                .ok()
                .entity(textService.getRandomParagraphsStatistics(paragraphGenerationInfo))
                .build();
    }

}
