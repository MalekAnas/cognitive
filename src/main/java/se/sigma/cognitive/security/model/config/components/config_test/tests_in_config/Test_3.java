package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button2;
import se.sigma.cognitive.security.model.config.components.config_test.ButtonSequence;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "test_3_config")

public class Test_3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int sequenceTestNr;
    @ElementCollection
    @CollectionTable(name = "button_show_order_test_3", joinColumns = @JoinColumn(name = "test_3_id"))
    private List<Integer> button_show_order;
    private ButtonSequence buttons_sequence;

    @ElementCollection
    @CollectionTable(name = "sequence_test_3", joinColumns = @JoinColumn(name = "test_3_id"))
    private List<Integer> sequence;
    private String completed_color;
    private String uncompleted_color;
    private String finished_color;

    @ElementCollection
    @CollectionTable(name = "buttons2_test_3", joinColumns = @JoinColumn(name = "test_3_id"))
    private List<Button2> buttons;
}
