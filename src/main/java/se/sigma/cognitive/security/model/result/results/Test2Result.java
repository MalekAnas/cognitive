package se.sigma.cognitive.security.model.result.results;


import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class Test2Result {



    private int button;
    private boolean answer;
    private long time;


}
