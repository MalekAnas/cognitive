package se.sigma.cognitive.security.model.config.components.config_test;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;


@Data
@Embeddable
public class Sequence2 {

    private List<Integer >color1;
    private List<Integer > color2;
    private List<Integer >button;

}
