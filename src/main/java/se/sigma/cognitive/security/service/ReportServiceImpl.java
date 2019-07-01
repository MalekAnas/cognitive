package se.sigma.cognitive.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.repository.ReportRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {


    @Autowired
    private ReportRepository reportRepository;


    @Override
    public List<Report> bringAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public void saveReport(Report report) {
        reportRepository.save(report);
    }








    public Report bringReportById(Long id){

        return reportRepository.findReportById(id);
    }

}
