package se.sigma.cognitive.security.model.config.components.config_test;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Data
@Embeddable
public class Admin {

    private List<Button> buttons;
}
