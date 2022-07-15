package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "styles")
@Entity
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private StyleType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public long getId() {
        return id;
    }

    public Style() {
    }

    public Style(StyleType name) {
        this.name = name;
    }

    public Style setId(long id) {
        this.id = id;
        return this;
    }

    public Style setName(StyleType name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Style setDescription(String description) {
        this.description = description;
        return this;
    }

    public StyleType getName() {
        return name;
    }


}
