package se.sigma.cognitive.security.controller;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.repository.ReportRepository;
import se.sigma.cognitive.security.service.ReportService;

import java.io.IOException;

@RestController
@RequestMapping("/user")
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



    private String getCurrentUserEmail() {


        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        String userName = userDetails.getUsername();


        return userName;
    }


    @PostMapping("/save_report")
    public void saveReport(@RequestBody String report) throws IOException {


        String userEmail = getCurrentUserEmail();
        ObjectMapper mapper= new ObjectMapper();


        Report report1 = mapper.readValue(report, Report.class);

        report1.setUserEmail(userEmail);

        reportService.saveReport(report1);
    }

//
//    @GetMapping("/tests")
//    public Iterable<Long> showTestIds(){
//        return reportService.allTestsInReport(6L);
//    }

}
