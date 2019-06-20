package se.sigma.cognitive.security.model.result.results;


import lombok.Data;

import javax.persistence.*;

@Data@Embeddable

public class Test11Result {



    private long time;

    private boolean result;
}
