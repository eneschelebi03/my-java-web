package com.example.spotifyplaylistapp.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "songs")
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String performer;

    @Column(nullable = false)
    private String title;

    private long duration;

    private LocalDate releaseDate;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Style style;

    public Style getStyle() {
        return style;
    }

    public long getId() {
        return id;
    }

    public Song setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Song setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public Song setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public Song setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Song setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Song setStyle(Style style) {
        this.style = style;
        return this;
    }

    private String toMinutes() {
        long minutes = this.duration / 60;
        long seconds = this.duration % 60;

        return String.format("%d:%d", minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("%s - %s (%s min)", this.performer, this.title, this.toMinutes());
    }
}
