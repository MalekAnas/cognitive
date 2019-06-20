package se.sigma.cognitive.security.controller;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.repository.ReportRepository;
import se.sigma.cognitive.security.service.ReportService;

import java.io.IOException;

@RestController
public class ReportController {



    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    public ReportController(ReportRepository reportRepository, ReportService reportService){
        this.reportRepository=reportRepository;
        this.reportService= reportService;
    }


    @GetMapping("/reports")
    public Iterable<Report> showReports(){
        return reportService.bringAllReports();
    }


    @GetMapping("/report/{id}")
    public Report getReport(@PathVariable Long id){
         return reportService.bringReportById(id);

    }


    @PostMapping("/save_report")
    public void saveReport(@RequestBody String report) throws IOException {

        ObjectMapper mapper= new ObjectMapper();


        Report report1 = mapper.readValue(report, Report.class);


        reportService.saveReport(report1);
    }
}
