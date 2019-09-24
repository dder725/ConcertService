package se325.assignment01.concert.service.domain;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="CONCERTS")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "BLURB", length = 1024)
    private String blurb;

    @ElementCollection
    @CollectionTable(name = "CONCERT_DATES")
    @Column(name = "DATE")
    private Set<LocalDateTime> dates = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinTable(name = "CONCERT_PERFORMER",
            joinColumns = {@JoinColumn(name = "CONCERT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERFORMER_ID")}
    )
    private Set<Performer> performers = new HashSet<>();


    // TODO Implement this class.
    //Default constructor required by JPA
    protected Concert(){}

    public Concert(Long id, String title, String imageName, Set<LocalDateTime> dates, Set<Performer> performers){
        this.id = id;
        this.title = title;
        this.dates = dates;
        //this.performers = performers;
    }

    public Set<LocalDateTime> getDates() {
        return dates;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


    public String getImageName() {
        return imageName;
    }


    public String getBlurb() {
        return blurb;
    }

    public Set<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<Performer> performers) {
        this.performers = performers;
    }
}
