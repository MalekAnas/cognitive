package se.sigma.cognitive.security.model.result.tests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se.sigma.cognitive.security.model.result.Report;
import se.sigma.cognitive.security.model.result.results.Test8Result;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "ORD_IGEN_KANNING_TEST")
public class Test8 {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ElementCollection
    @CollectionTable(name = "test8_result", joinColumns = @JoinColumn(name = "test8_id"))
    private List<Test8Result> results = new ArrayList<>();

//
//    @OneToOne(mappedBy = "test8")
//    private Report report;


}
