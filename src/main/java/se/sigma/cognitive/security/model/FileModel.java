package se.sigma.cognitive.security.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Report")
@Data
public class FileModel {

    @Id
    @GeneratedValue(generator = "uuid")
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;


}
