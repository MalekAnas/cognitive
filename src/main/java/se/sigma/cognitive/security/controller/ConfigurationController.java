package se.sigma.cognitive.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.sigma.cognitive.security.model.config.ConfigTest;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.service.ConfigTestService;

import java.io.IOException;



@RestController
public class ConfigurationController {



    @Autowired
    private ConfigTestService configTestService;

    @Autowired
    public ConfigurationController(ConfigTestService configTestService){
        this.configTestService = configTestService;
    }





    @PostMapping("/save_config")
    public void saveReport(@RequestBody String configTest) throws IOException {


//        String userEmail = getCurrentUserEmail();
        ObjectMapper mapper= new ObjectMapper();


        ConfigTest config = mapper.readValue(configTest , ConfigTest.class);

//        report1.setUserEmail(userEmail);

        configTestService.saveConfiguration(config);
    }
}
