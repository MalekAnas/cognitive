package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.Button2;

import javax.persistence.*;
import java.util.List;


@Data
@Entity

@Table(name = "test_8_config")

public class Test_8 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    private int nr_od_words;

    @ElementCollection
    @CollectionTable(name = "original_words_test_8", joinColumns = @JoinColumn(name = "test_8_id"))
    private List<String> original_words;

    @ElementCollection
    @CollectionTable(name = "new_words_test_8", joinColumns = @JoinColumn(name = "test_8_id"))
    private List<String> new_words;

    @ElementCollection
    @CollectionTable(name = "sequence_test_8", joinColumns = @JoinColumn(name = "test_8_id"))
    private List<Integer> sequence;

    @ElementCollection
    @CollectionTable(name = "buttons_test_8", joinColumns = @JoinColumn(name = "test_8_id"))
    private List<Button2> buttons;

}
