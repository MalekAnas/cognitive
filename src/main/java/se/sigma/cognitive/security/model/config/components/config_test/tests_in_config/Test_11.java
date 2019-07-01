package se.sigma.cognitive.security.model.config.components.config_test.tests_in_config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import se.sigma.cognitive.security.model.config.components.config_test.TestSquare;

import javax.persistence.*;
import java.util.List;


@Data
@Entity

@Table(name = "test_11_config")

public class Test_11 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;


    @ElementCollection
    @CollectionTable(name = "test_squares_test_11", joinColumns = @JoinColumn(name = "test_11_id"))
    private List<TestSquare> testSquares;

}
