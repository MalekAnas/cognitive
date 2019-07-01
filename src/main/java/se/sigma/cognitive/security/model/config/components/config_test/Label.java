package se.sigma.cognitive.security.model.config.components.config_test;


import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Label {

    private String text_color;
    private String background_color;
    private String text;
}
