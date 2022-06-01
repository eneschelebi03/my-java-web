package bg.softuni.mobilele.entity;

import bg.softuni.mobilele.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    private String imageURL;

    private int startYear;

    private Long endYear;
}
