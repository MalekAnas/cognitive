package se.sigma.cognitive.security.model.result.tests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test1Result;
import se.sigma.cognitive.security.model.result.results.Test9Result;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "FINGER_TAPPING_TEST")
public class Test9 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean failedTest;


    @ElementCollection
    @CollectionTable(name = "test9_result", joinColumns = @JoinColumn(name = "test9_id"))
    private List<Test9Result> results = new ArrayList<>();
//
//
//    @OneToOne(mappedBy = "test9")
//    private Report report;

}
