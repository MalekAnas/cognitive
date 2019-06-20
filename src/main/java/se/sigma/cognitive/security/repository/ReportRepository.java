package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.sigma.cognitive.security.model.result.Report;


@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


    Report findReportById(Long id);


//
//    @Query(value = "select * from test1, test2,test3,test4,test5,test6,test7,test8,test9,test10,test11 where report_id = :id " , nativeQuery = true)
//    Report getCompleteReport(Long reportId);


}
