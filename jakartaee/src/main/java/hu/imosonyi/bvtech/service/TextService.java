package hu.imosonyi.bvtech.service;

import hu.imosonyi.bvtech.dto.ParagraphGenerationInfo;
import hu.imosonyi.bvtech.dto.RandomParagraphsStatistics;

public interface TextService {

    RandomParagraphsStatistics getRandomParagraphsStatistics (
            ParagraphGenerationInfo paragraphGenerationInfo);

}
