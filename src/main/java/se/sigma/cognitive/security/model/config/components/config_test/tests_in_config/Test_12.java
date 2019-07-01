package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test_12_config")

public class Test_12 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int testDuration;
}
