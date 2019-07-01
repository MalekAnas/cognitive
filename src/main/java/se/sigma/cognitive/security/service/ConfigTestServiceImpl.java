package se.sigma.cognitive.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sigma.cognitive.security.model.config.ConfigTest;
import se.sigma.cognitive.security.repository.ConfigTestRepository;



@Service
public class ConfigTestServiceImpl implements ConfigTestService {

    @Autowired
    private ConfigTestRepository configTestRepository;

    @Override
    public void saveConfiguration(ConfigTest configTest) {

        configTestRepository.save(configTest);
    }
}
