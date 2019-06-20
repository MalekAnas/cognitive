package se.sigma.cognitive.security.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "files")
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
