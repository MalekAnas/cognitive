package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button2;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "test_9_config")


public class Test_9 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int testRepetitions;
    private int repetitions;
    private int delay;
    private int subDelay;
    private String completed_color;
    private String uncompleted_color;

    @ElementCollection
    @CollectionTable(name = "sequence_test_9", joinColumns = @JoinColumn(name = "test_9_id"))
    private List<Integer> sequence;

    @ElementCollection
    @CollectionTable(name = "buttons2_test_9", joinColumns = @JoinColumn(name = "test_9_id"))
    private List<Button2> buttons;


}
