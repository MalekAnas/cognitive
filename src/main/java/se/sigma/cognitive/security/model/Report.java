package se.sigma.cognitive.security.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Data
public class Report {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private MultipartFile report;




    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Report(String fileName, String contentType, byte[] bytes) {
    }


}
