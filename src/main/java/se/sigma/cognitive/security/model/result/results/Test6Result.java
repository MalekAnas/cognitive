package se.sigma.cognitive.security.model.result.results;

import lombok.Data;

import javax.persistence.*;

@Data@Embeddable
public class Test6Result {


    private int recordingIndex;
    private String word;


}
