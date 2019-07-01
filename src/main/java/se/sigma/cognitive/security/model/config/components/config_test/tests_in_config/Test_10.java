package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button2;
import se.sigma.cognitive.security.model.config.components.config_test.Label;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "test_10_config")

public class Test_10 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;


    @ElementCollection
    @CollectionTable(name = "labels_test_10", joinColumns = @JoinColumn(name = "test_10_id"))
    private List<Label> labels;

    @ElementCollection
    @CollectionTable(name = "buttons_test_10", joinColumns = @JoinColumn(name = "test_10_id"))
    private List<Button2> buttons;
}
