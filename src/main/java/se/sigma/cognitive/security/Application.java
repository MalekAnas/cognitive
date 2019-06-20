package se.sigma.cognitive.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.service.ReportService;
import se.sigma.cognitive.security.util.FileStorageProperties;

import java.io.InputStream;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



    @Bean
    CommandLineRunner runner(ReportService reportService){
        return args -> {
            ObjectMapper mapper= new ObjectMapper();


            TypeReference<Report> typeReference= new TypeReference<Report>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/generated.json");
            try {
                Report report=mapper.readValue(inputStream, typeReference);
                reportService.saveReport(report);
                System.out.println("Report saved!");
            }
            catch (Exception e){
                System.out.println("Unable to save report" + e.getMessage());
            }
        };
    }
}