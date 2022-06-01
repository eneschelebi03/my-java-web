package bg.softuni.intro.cats.models.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL
    )
    private List<Cat> cats = new ArrayList<>();

    public long getId() {
        return id;
    }

    public Owner setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Owner setName(String name) {
        this.name = name;
        return this;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public Owner setCats(List<Cat> cats) {
        this.cats = cats;
        return this;
    }

    public void addCat(Cat cat) {
        cats.add(cat);
    }
}
