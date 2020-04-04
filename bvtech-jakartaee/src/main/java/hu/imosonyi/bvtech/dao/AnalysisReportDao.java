package hu.imosonyi.bvtech.dao;

import java.util.List;

import hu.imosonyi.bvtech.model.AnalysisReport;

/**
 * Functions for storing and retrieving analysis reports.
 *
 * @author István Mosonyi
 */
public interface AnalysisReportDao extends Dao<AnalysisReport> {

    /**
     * Retrieve the last n reports.
     *
     * @param limit The number of reports to request.
     * @return List of reports.
     */
    List<AnalysisReport> findLastNReports (Integer limit);

}
