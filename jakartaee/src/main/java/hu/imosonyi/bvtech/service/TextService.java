package hu.imosonyi.bvtech.service;

import hu.imosonyi.bvtech.dto.ParagraphGenerationInfo;
import hu.imosonyi.bvtech.dto.RandomTextParagraphsStatistics;

public interface TextService {

    RandomTextParagraphsStatistics getRandomParagraphsStatistics (
            ParagraphGenerationInfo paragraphGenerationInfo);

}
