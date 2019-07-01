package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.BtnPosition;
import se.sigma.cognitive.security.model.config.components.config_test.Button;
import se.sigma.cognitive.security.model.config.components.config_test.Sequence;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test_0_config")
public class Test_0 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private int repetitions;
    private int delay_min;
    private int delay_max;
    private int delay_between;
    private boolean onlyTest;

    private Sequence sequence;



    @ElementCollection
    @CollectionTable(name = "btn_position_test_0", joinColumns = @JoinColumn(name = "test_0_id"))
    private List<BtnPosition> btnPosition;

    @ElementCollection
    @CollectionTable(name = "buttons_test_0", joinColumns = @JoinColumn(name = "test_0_id"))
    private List<Button> buttons;
}
