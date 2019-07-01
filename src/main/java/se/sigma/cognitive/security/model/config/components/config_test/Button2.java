package se.sigma.cognitive.security.model.config.components.config_test;


import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable

public class Button2 {


    private String background_color;
    private boolean btnShow;
    private Location location;
    private String text_color;
    private String text;
}
