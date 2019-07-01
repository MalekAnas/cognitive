package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button;
import se.sigma.cognitive.security.model.config.components.config_test.Image;
import se.sigma.cognitive.security.model.config.components.config_test.Sequence;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test_1_config")

public class Test_1 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private int repetitions;
    private int traningRepetitions;
    private int delay_min;
    private int delay_max;
    private int sequenceTestNr;
    private boolean onlyTest;

    private Sequence sequence;
    @ElementCollection
    @CollectionTable(name = "images_test_1", joinColumns = @JoinColumn(name = "test_1_id"))
    private List<Image> images;
    @ElementCollection
    @CollectionTable(name = "buttons_test_1", joinColumns = @JoinColumn(name = "test_1_id"))
    private List<Button> buttons;

}
