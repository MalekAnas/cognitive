package se.sigma.cognitive.security.model.result.tests;

import lombok.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test1Result;

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
@Table(name = "REAKTIONSTIDTEST")

public class Test1 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @AssertFalse
    private boolean failedTest;


    @ElementCollection
    @CollectionTable(name = "test1_result", joinColumns = @JoinColumn(name = "test1_id"))
    private List<Test1Result> results = new ArrayList<>();


    @OneToOne(mappedBy = "test1")
    private Report report;
}