package se.sigma.cognitive.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import se.sigma.cognitive.security.exception.FileStorageException;
import se.sigma.cognitive.security.exception.MyFileNotFoundException;
import se.sigma.cognitive.security.model.FileModel;
import se.sigma.cognitive.security.repository.DBFileRepository;
import se.sigma.cognitive.security.util.AppConstants;
import se.sigma.cognitive.security.util.FileStorageProperties;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Service
public class FileStorageServiceImpl implements FileStorageService {


    private final Path fileStorageLocation;


    @Autowired
    private DBFileRepository dbFileRepository;

    @Autowired
    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new FileStorageException(AppConstants.FILE_STORAGE_EXCEPTION_PATH_NOT_FOUND, e);
        }
    }


    @Override
    public FileModel storeFile(MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! your file contails invalid characters...");
            }

            FileModel fileModel = new FileModel();
            fileModel.setFileName(fileName);
            fileModel.setFileType(file.getContentType());
            fileModel.setData(file.getBytes());

            return dbFileRepository.save(fileModel);

        } catch (IOException ioe) {
            throw new FileStorageException("could not store file " + fileName + " Please try again, " + ioe);
        }

    }

    @Override
    public FileModel getFile(Long fileId) {

        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("FileModel not found with id " + fileId));
    }
}