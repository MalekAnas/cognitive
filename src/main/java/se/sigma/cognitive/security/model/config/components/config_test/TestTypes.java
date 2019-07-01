package se.sigma.cognitive.security.model.config.components.config_test;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
public class TestTypes {

    private List<Integer> _long;
    private List<Integer> _short;
}
