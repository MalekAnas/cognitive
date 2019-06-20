package se.sigma.cognitive.security.model.result.tests;

import lombok.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.recordings.Recordings;
import se.sigma.cognitive.security.model.result.results.Test1Result;
import se.sigma.cognitive.security.model.result.results.Test7Result;

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
@Table(name = "MINNESTEST_UTAN_LISTAN_VISAS_IGEN")
public class Test7 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @AssertFalse
    private boolean failedTest;


    @ElementCollection
    @CollectionTable(name = "test7_result", joinColumns = @JoinColumn(name = "test7_id"))
    private List<Test7Result> results = new ArrayList<>();


    @OneToOne(mappedBy = "test7")
    private Report report;


    @ElementCollection
    @CollectionTable(name = "test7_recordings", joinColumns = @JoinColumn(name = "test7_id"))
    private List<Recordings> recordings;

}
