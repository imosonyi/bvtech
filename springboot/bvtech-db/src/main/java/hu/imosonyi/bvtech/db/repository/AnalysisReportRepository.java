package hu.imosonyi.bvtech.db.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import hu.imosonyi.bvtech.db.model.AnalysisReport;

public interface AnalysisReportRepository extends CrudRepository<AnalysisReport, Long> {
    
    List<AnalysisReport> findTop10ByOrderByCreatedAtDesc ();

}
