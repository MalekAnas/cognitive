package se.sigma.cognitive.security.model.result.tests;

import lombok.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test5Result;

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
@Table(name = "STROOP_FARG_ORD_2")
public class Test5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ElementCollection
    @CollectionTable(name = "test5_result", joinColumns = @JoinColumn(name = "test5_id"))
    private List<Test5Result> results = new ArrayList<>();


    @OneToOne(mappedBy = "test5")
    private Report report;
}
