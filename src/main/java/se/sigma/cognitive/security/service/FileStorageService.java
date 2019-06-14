package se.sigma.cognitive.security.service;

import org.springframework.web.multipart.MultipartFile;
import se.sigma.cognitive.security.model.FileModel;

public interface FileStorageService {



    public FileModel storeFile(MultipartFile file);

    public FileModel getFile(Long fileId);
}
