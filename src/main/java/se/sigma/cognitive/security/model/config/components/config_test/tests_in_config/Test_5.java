package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button2;
import se.sigma.cognitive.security.model.config.components.config_test.Image;
import se.sigma.cognitive.security.model.config.components.config_test.Label;
import se.sigma.cognitive.security.model.config.components.config_test.Sequence2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "test_5_config")

public class Test_5 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int sequenceTestNr;
    private int betweenButtInterval;
    private int repetitions;


    private Sequence2 sequence;
    @ElementCollection
    @CollectionTable(name = "colors_test_5", joinColumns = @JoinColumn(name = "test_5_id"))
    private List<String> colors;
    @ElementCollection
    @CollectionTable(name = "images_test_5", joinColumns = @JoinColumn(name = "test_5_id"))
    private List<Image> images;

    @ElementCollection
    @CollectionTable(name = "btns_test_5", joinColumns = @JoinColumn(name = "test_5_id"))
    private List<Button2> buttons;
    @ElementCollection
    @CollectionTable(name = "labels_test_5", joinColumns = @JoinColumn(name = "test_5_id"))
    private List<Label> labels;

}
