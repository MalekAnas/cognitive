package se.sigma.cognitive.security.model.result.tests;

import lombok.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.recordings.Recordings;
import se.sigma.cognitive.security.model.result.results.Test6Result;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "MINNESTEST_10_ORD_VISAS_10_GGR")
public class Test6 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @AssertFalse
    private boolean failedTest;


    @ElementCollection
    @CollectionTable(name = "test6_result", joinColumns = @JoinColumn(name = "test6_id"))
    private List<Test6Result> results = new ArrayList<>();

//
//    @OneToOne(mappedBy = "test1")
//    private Report report;


    @ElementCollection
    @CollectionTable(name = "test6_recordings", joinColumns = @JoinColumn(name = "test6_id"))
    private List<Recordings> recordings;
}
