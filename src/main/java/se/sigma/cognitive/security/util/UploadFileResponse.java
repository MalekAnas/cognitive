package se.sigma.cognitive.security.util;


import lombok.Data;

@Data
public class UploadFileResponse {



    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
}
