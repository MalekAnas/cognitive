package se.sigma.cognitive.security.service;

import org.springframework.web.multipart.MultipartFile;
import se.sigma.cognitive.security.exception.MyFileNotFoundException;
import se.sigma.cognitive.security.model.Report;

import java.io.IOException;

public interface ReportService {


    Report storeReport(MultipartFile report) throws IOException;
    Report getReport(String reportId) throws MyFileNotFoundException;
}
