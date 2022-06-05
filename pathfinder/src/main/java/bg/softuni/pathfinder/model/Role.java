package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private UserRole name;

    public Role() {
    }

    public long getId() {
        return id;
    }

    public Role setId(long id) {
        this.id = id;
        return this;
    }

    public UserRole getName() {
        return name;
    }

    public Role setName(UserRole name) {
        this.name = name;
        return this;
    }
}
