package se.sigma.cognitive.security.model.result.tests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.recordings.Recordings;
import se.sigma.cognitive.security.model.result.results.Test12Result;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "TEST_12")
public class Test12 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ElementCollection
    @CollectionTable(name = "test12_result", joinColumns = @JoinColumn(name = "test12_id"))
    private List<Test12Result> results = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "test12_recordings", joinColumns = @JoinColumn(name = "test12_id"))
    private List<Recordings> recordings;

    @OneToOne(mappedBy = "test12")
    private Report report;
}


