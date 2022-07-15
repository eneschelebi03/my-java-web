package com.example.spotifyplaylistapp.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class AddSongDTO {

    @Size(min = 3, max = 20)
    private String performer;

    @Size(min = 2, max = 20)
    private String title;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Positive
    private long duration;

    @NotBlank
    private String style;

    public String getPerformer() {
        return performer;
    }

    public AddSongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AddSongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AddSongDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public long getDuration() {
        return duration;
    }

    public AddSongDTO setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public String getStyle() {
        return style;
    }

    public AddSongDTO setStyle(String style) {
        this.style = style;
        return this;
    }
}
