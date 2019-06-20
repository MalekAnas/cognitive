package se.sigma.cognitive.security.model.result.results;


import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Test10Result {






    @Column(name = "question")
    private String question;

    private boolean answer;

}
