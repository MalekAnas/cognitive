package se.sigma.cognitive.security.model.result.tests;

import lombok.*;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test3Result;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TRAILMAKINGTEST_B")
public class Test3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ElementCollection
    @CollectionTable(name = "test3_result", joinColumns = @JoinColumn(name = "test3_id"))
    private List<Test3Result> results = new ArrayList<>();


    @OneToOne(mappedBy = "test3")
    private Report report;
}

