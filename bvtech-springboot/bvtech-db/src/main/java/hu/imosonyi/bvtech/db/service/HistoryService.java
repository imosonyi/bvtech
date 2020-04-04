package hu.imosonyi.bvtech.db.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.imosonyi.bvtech.db.dto.TextResponse;
import hu.imosonyi.bvtech.db.repository.AnalysisReportRepository;
import hu.imosonyi.bvtech.db.util.TextResponseToAnalysisReportConverter;

@Service
public class HistoryService {

    @Autowired
    private AnalysisReportRepository analysisReportRepository;

    private TextResponseToAnalysisReportConverter converter =
            new TextResponseToAnalysisReportConverter();

    /**
     * TODO.
     * @return
     */
    public List<TextResponse> getHistory () {
        return analysisReportRepository.findTop10ByOrderByCreatedAtDesc()
                .stream()
                .map(converter::revert)
                .collect(Collectors.toList());
    }

}
