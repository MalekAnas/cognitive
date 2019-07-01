package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button;

import javax.persistence.*;
import java.util.List;


@Data
@Entity

@Table(name = "test_7_config")


public class Test_7 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int waitingSeconds;
    private String videoTest;

    @ElementCollection
    @CollectionTable(name = "buttons_test_7", joinColumns = @JoinColumn(name = "test_7_id"))
    private List<Button> buttons;
}
