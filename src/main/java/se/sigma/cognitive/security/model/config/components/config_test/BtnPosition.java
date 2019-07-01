package se.sigma.cognitive.security.model.config.components.config_test;


import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class BtnPosition {

    private boolean show;
    private int x;
    private int y;
}
