package se.sigma.cognitive.security.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import se.sigma.cognitive.security.model.result.tests.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Report")
public class Report {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String patientsName;


    @Type(type="date")
    private Date date;




    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test1 test1;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test2 test2;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test3 test3;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test4 test4;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test5 test5;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test6 test6;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test7 test7;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test8 test8;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test9 test9;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test10 test10;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test11 test11;

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Test12 test12;





}
