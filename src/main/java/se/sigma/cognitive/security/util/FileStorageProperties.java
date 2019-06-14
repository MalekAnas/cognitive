package se.sigma.cognitive.security.util;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = AppConstants.FILE_PROPERTY_PREFIX)
@Data
public class FileStorageProperties {

    private String uploadDir;

}
