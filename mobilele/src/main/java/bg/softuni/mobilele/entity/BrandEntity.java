package bg.softuni.mobilele.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column
    private String name;
}
