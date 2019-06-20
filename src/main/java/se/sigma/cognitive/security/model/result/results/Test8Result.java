package se.sigma.cognitive.security.model.result.results;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Test8Result {


    private String word;

    private boolean wasActuallyShown;
    private boolean answeredThatItWasShown;
    private boolean answer;

}
