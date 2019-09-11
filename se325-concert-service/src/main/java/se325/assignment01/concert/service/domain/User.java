package se325.assignment01.concert.service.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    protected User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
