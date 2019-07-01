package se.sigma.cognitive.security.model.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.KeyCodeToClick;
import se.sigma.cognitive.security.model.config.components.config_test.TestTypes;
import se.sigma.cognitive.security.model.config.components.config_test.Timer;
import se.sigma.cognitive.security.model.config.components.config_test.tests_in_config.*;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "configuration1")
public class ConfigTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    private Timer timer;
    private TestTypes testtypes;
    private int button_sequence;
    private String language_template;
    private KeyCodeToClick keycodeToClick;


    @ElementCollection
    @CollectionTable(name = "verifyKlaratTestObj", joinColumns = @JoinColumn(name = "config_test_id"))
    private List<String> verifyKlaratTestObj;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_0 test_0;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_1 test_1;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_2 test_2;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_3 test_3;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_4 test_4;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_5 test_5;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_6 test_6;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_7 test_7;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_8 test_8;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_9 test_9;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_10 test_10;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_11 test_11;
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test_12 test_12;


}
