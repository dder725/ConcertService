package se325.assignment01.concert.service.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column( name = "VERSION")
    private Long version;

    protected User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
