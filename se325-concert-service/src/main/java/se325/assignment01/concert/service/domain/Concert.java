package se325.assignment01.concert.service.domain;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name="CONCERTS")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imageName;

    private String blurb;

    @ElementCollection
    @Column(name = "DATES")
    @CollectionTable(name = "CONCERT_DATES")
    private List<LocalDateTime> dates = new ArrayList<>();

    @ElementCollection
    @Column(name= "PERFORMERS")
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "CONCERT_PERFORMER",
            joinColumns = @JoinColumn(name = "CONCERT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERFORMER_ID")
    )
    private List<Performer> performers = new ArrayList<>();


    // TODO Implement this class.
    //Default constructor required by JPA
    protected Concert(){}

    public Concert(Long id, String title, String imageName, List<LocalDateTime> dates, List<Performer> performers){
        this.id = id;
        this.title = title;
        this.dates = dates;
        this.performers = performers;
    }

    public Set<LocalDateTime> getDates() {
        return null;
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

    public List<Performer> getPerformers() {
        return performers;
    }

}
