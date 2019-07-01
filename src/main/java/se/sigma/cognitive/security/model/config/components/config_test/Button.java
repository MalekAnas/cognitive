package se.sigma.cognitive.security.model.config.components.config_test;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Button {

    private String src;
    private String link;
    private String title;
    private boolean show;
}
