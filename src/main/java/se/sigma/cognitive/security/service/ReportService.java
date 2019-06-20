package se.sigma.cognitive.security.service;

import se.sigma.cognitive.security.model.result.Report;

import java.util.List;

public interface ReportService {

    List<Report> bringAllReports();

    void saveReport(Report report);

    Report bringReportById(Long id);
}
