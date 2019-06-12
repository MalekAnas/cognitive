package se.sigma.cognitive.security.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Role {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;



    @ManyToMany
    private Collection<User> users;

    public Role(){

    }

    public Role(String name){
        this.name=name;
    }
}
