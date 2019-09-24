package se325.assignment01.concert.service.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import se325.assignment01.concert.common.types.Genre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PERFORMERS")
public class Performer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private Genre genre;

    @Column(name = "BLURB", length = 1024)
    private String blurb;

    @ManyToMany(mappedBy = "performers", fetch = FetchType.LAZY)
    private Set<Concert> concerts = new HashSet<>();
    //Default constructor required by JPA
    protected Performer(){}

    public Performer(Long id, String name, String imageName, Genre genre, String blurb){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.blurb = blurb;
        this.imageName = imageName;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageName() {
        return imageName;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getBlurb() {
        return blurb;
    }

}
