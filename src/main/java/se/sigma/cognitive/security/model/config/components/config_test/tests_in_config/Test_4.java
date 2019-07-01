package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button2;
import se.sigma.cognitive.security.model.config.components.config_test.Image;
import se.sigma.cognitive.security.model.config.components.config_test.Sequence2;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "test_4_config")

public class Test_4 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int sequenceTestNr;
    private int betweenButtInterval;
    private int repetitions;
    private Sequence2 sequence;

    @ElementCollection(targetClass=String.class)
    @CollectionTable(name = "colors_test_4", joinColumns = @JoinColumn(name = "test_4_id"))
    private List<String> colors= new ArrayList<>();
    @ElementCollection(targetClass=Image.class)
    @CollectionTable(name = "images_test_4", joinColumns = @JoinColumn(name = "test_4_id"))
    private List<Image> images= new ArrayList<>();
    @ElementCollection(targetClass=Button2.class)
    @CollectionTable(name = "btn2_test_4", joinColumns = @JoinColumn(name = "test_4_id"))
    private List<Button2> buttons= new ArrayList<>();
}
