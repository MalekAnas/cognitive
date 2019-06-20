package se.sigma.cognitive.security.model.result.recordings;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.sigma.cognitive.security.model.result.tests.Test6;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Recordings {




    private String recordingPath;



}
