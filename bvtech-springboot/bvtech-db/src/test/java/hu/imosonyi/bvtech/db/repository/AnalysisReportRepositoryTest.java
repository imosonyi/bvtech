package hu.imosonyi.bvtech.db.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import hu.imosonyi.bvtech.db.model.AnalysisReport;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnalysisReportRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AnalysisReportRepository analysisReportRepository;

    @Test
    public void testFindTop10ByOrderByCreatedAtDescShouldReturnInDescOrder () {
        for (int i = 0; i < 20; i++) {
            entityManager.persist(generateReport());
        }
        entityManager.flush();

        List<AnalysisReport> result = analysisReportRepository.findTop10ByOrderByCreatedAtDesc();

        for (int i = 0; i < result.size() - 1; i++) {
            assertThat(result.get(i).getCreatedAt(), is(greaterThanOrEqualTo(result.get(i + 1).getCreatedAt())));
        }
    }

    @Test
    public void testFindTop10ByOrderByCreatedAtDescShouldReturn10Results () {
        for (int i = 0; i < 20; i++) {
            entityManager.persist(generateReport());
        }
        entityManager.flush();

        List<AnalysisReport> result = analysisReportRepository.findTop10ByOrderByCreatedAtDesc();

        assertThat(result.size(), is(equalTo(10)));
    }

    private AnalysisReport generateReport () {
        AnalysisReport report = new AnalysisReport();
        report.setAverageParagraphProcessingTime(1.0);
        report.setAverageParagraphSize(1.0);
        report.setMostFrequentWord("");
        report.setTotalProcessingTime(1L);
        return report;
    }

}
