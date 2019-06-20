package se.sigma.cognitive.security.model.result.tests;


import lombok.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test2Result;

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
@Table(name = "TRAILMAKINGTEST_A")
public class Test2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @AssertFalse
    private boolean failedTest;


    @ElementCollection
    @CollectionTable(name = "test2_result", joinColumns = @JoinColumn(name = "test2_id"))
    private List<Test2Result> results = new ArrayList<>();


    @OneToOne(mappedBy = "test2")
    private Report report;

}
