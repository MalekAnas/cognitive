package se.sigma.cognitive.security.model;


import lombok.Data;
import se.sigma.cognitive.security.model.result.Report;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class User {


    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userNickName;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private boolean enabled;



    private String createdBy;




    @ElementCollection
    @CollectionTable()
    private List<User> partners =new ArrayList<>();

    @ElementCollection
    @CollectionTable()
    private List<User> admins =new ArrayList<>();

    @ElementCollection
    @CollectionTable()
    private List<User> users =new ArrayList<>();





    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;



    @ElementCollection
    @CollectionTable()
    private List<Report> reports =new ArrayList<>();




}
