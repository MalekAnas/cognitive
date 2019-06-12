package se.sigma.cognitive.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.sigma.cognitive.security.model.Report;

import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Report getById(String reportId);

    Optional<Object> findById(String reportId);

    Report getReportById(Long id);
}
