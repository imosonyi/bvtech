package hu.imosonyi.bvtech.service;

import hu.imosonyi.bvtech.dto.TextRequest;
import hu.imosonyi.bvtech.dto.TextResponse;

public interface TextService {

    TextResponse getStatistics (TextRequest textRequest);

}
