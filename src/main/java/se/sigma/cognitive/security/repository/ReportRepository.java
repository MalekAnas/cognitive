package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import se.sigma.cognitive.security.model.result.Report;

import java.util.Date;


@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {


    Report findReportById(Long id);




}
