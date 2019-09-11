package se325.assignment01.concert.service.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import se325.assignment01.concert.common.types.Genre;

import javax.persistence.*;

@Entity
public class Performer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageName;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    private String blurb;

    //Default constructor required by JPA
    protected Performer(){}

    public Performer(Long id, String name, Genre genre, String blurb){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.blurb = blurb;
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
