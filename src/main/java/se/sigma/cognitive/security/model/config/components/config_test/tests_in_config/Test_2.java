package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button2;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "test_2_config")
public class Test_2 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int sequenceTestNr;

    @ElementCollection
    @CollectionTable(name = "btn_show_order_test_2", joinColumns = @JoinColumn(name = "test_2_id"))
    private List<Integer> button_show_order;

    @ElementCollection
    @CollectionTable(name = "sequence_test_2", joinColumns = @JoinColumn(name = "test_2_id"))
    private List<Integer> sequence;

    private String completed_color;
    private String uncompleted_color;
    private String finished_color;

    @ElementCollection
    @CollectionTable(name = "btn_order_test_2", joinColumns = @JoinColumn(name = "test_2_id"))
    private List<Integer> button_order;

    @ElementCollection
    @CollectionTable(name = "buttons_test_2", joinColumns = @JoinColumn(name = "test_2_id"))
    private List<Button2> buttons;

}
