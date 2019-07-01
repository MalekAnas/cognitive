package se.sigma.cognitive.security.model.result.tests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test11Result;
import se.sigma.cognitive.security.model.result.results.Test1Result;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "TEST_11")
public class Test11 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ElementCollection
    @CollectionTable(name = "test11_result", joinColumns = @JoinColumn(name = "test11_id"))
    private List<Test11Result> results = new ArrayList<>();


//    @OneToOne(mappedBy = "test11")
//    private Report report;
}
