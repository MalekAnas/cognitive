package se.sigma.cognitive.security.model.result.tests;

import lombok.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test4Result;

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
@Table(name = "STROOP_FARG_ORD_1")
public class Test4 {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @AssertFalse
    private boolean failedTest;


    @ElementCollection
    @CollectionTable(name = "test4_result", joinColumns = @JoinColumn(name = "test4_id"))
    private List<Test4Result> results = new ArrayList<>();

//
//    @OneToOne(mappedBy = "test4")
//    private Report report;
}
