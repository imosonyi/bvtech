package hu.imosonyi.bvtech.service.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;
import hu.imosonyi.bvtech.service.TextService;

@RequestScoped
public class TextServiceImpl implements TextService {

    @Inject
    private ApiServiceImpl apiService;
    
    @Override
    public TextResponse getStatistics (TextRequest textRequest) {
        TextResponse textResponse = apiService.analyze(textRequest);
        // TODO: save in database
        return textResponse;
    }

}
