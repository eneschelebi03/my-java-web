package bg.softuni.intro.cats.models.entity;


import javax.persistence.*;

@Entity
@Table(name = "cats")
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Owner owner;

    public long getId() {
        return id;
    }

    public Cat setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cat setName(String name) {
        this.name = name;
        return this;
    }

    public Owner getOwner() {
        return owner;
    }

    public Cat setOwner(Owner owner) {
        this.owner = owner;
        return this;
    }
}
