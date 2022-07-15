package bg.softuni.battleships.model.dto;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AddShipDTO {

    @Size(min = 2, max = 10)
    @NotBlank
    private String name;

    @Positive
    private int power;

    @Positive
    private int health;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate created;

    @NotNull
    private String category;

    public String getName() {
        return name;
    }

    public AddShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getPower() {
        return power;
    }

    public AddShipDTO setPower(int power) {
        this.power = power;
        return this;
    }

    public int getHealth() {
        return health;
    }

    public AddShipDTO setHealth(int health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public AddShipDTO setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public AddShipDTO setCategory(String category) {
        this.category = category;
        return this;
    }

}
