package se.sigma.cognitive.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import se.sigma.cognitive.security.exception.FileStorageException;
import se.sigma.cognitive.security.exception.MyFileNotFoundException;
import se.sigma.cognitive.security.model.Report;
import se.sigma.cognitive.security.repository.ReportRepository;

import java.io.IOException;

@Service
public class ReportServiceImpl implements ReportService {



    @Autowired
    private ReportRepository reportRepository;

    public Report storeReport(MultipartFile report) throws IOException {
        String fileName = StringUtils.cleanPath(report.getOriginalFilename());

        try {
            if (fileName.contains("..")){
                throw new FileStorageException("sorry! Filename contains invalid path sequence" + fileName);
            }
        } catch (FileStorageException e) {
            e.printStackTrace();
        }


        Report reportFile = new Report(fileName, report.getContentType(), report.getBytes());

        return reportRepository.save(reportFile);
    }

    public Report getReport(String reportId) throws MyFileNotFoundException {
        return (Report) reportRepository.findById(reportId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + reportId));
    }

}
