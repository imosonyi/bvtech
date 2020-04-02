package hu.imosonyi.bvtech.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import hu.imosonyi.bvtech.dao.AnalysisReportDao;
import hu.imosonyi.bvtech.model.AnalysisReport;

/**
 * Implements the {@link AnalysisReportDao} interface.
 *
 * @author István Mosonyi
 */
@Stateless
public class AnalysisReportDaoImpl extends AbstractDao<AnalysisReport>
        implements AnalysisReportDao {

    protected AnalysisReportDaoImpl () {
        super(AnalysisReport.class);
    }

    @Override
    public List<AnalysisReport> findLastNReports (Integer limit) {
        return createNamedQuery("AnalysisReport.findAllOrderByCreatedAtDesc")
                .setMaxResults(limit)
                .getResultList();
    }

}
