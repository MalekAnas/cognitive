package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity

@Table(name = "test_6_config")

public class Test_6 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @ElementCollection
    @CollectionTable(name = "word_sequence1_test_6", joinColumns = @JoinColumn(name = "test_6_id"))
    private List<String> word_sequence1;

    @ElementCollection
    @CollectionTable(name = "word_sequence2_test_6", joinColumns = @JoinColumn(name = "test_6_id"))
    private List<String> word_sequence2;

    @ElementCollection
    @CollectionTable(name = "word_sequence3_test_6", joinColumns = @JoinColumn(name = "test_6_id"))
    private List<String> word_sequence3;
    private int sequenceTestNr;
    private int howMuchRepeatTest;
    private int howMuchRepeat;
    private int repetitions;
    private int delay;
    private int waitingSeconds;

    @ElementCollection
    @CollectionTable(name = "buttons_test_6", joinColumns = @JoinColumn(name = "test_6_id"))
    private List<Button> buttons;

}
