package se.sigma.cognitive.security.model.result.tests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test10Result;
import se.sigma.cognitive.security.model.result.results.Test1Result;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "DEPRESSIONSSKATTNING_TEST")
public class Test10 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ElementCollection
    @CollectionTable(name = "test10_result", joinColumns = @JoinColumn(name = "test10_id"))
    private List<Test10Result> results = new ArrayList<>();
//
//
//    @OneToOne(mappedBy = "test10")
//    private Report report;
}
