package com.example.spotifyplaylistapp.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private long id;

    private String username;

    public long getId() {
        return id;
    }

    public LoggedUser setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public void clear() {
        this.id = 0;
        this.username = null;
    }

    public void login(long id, String username) {
        this.id = id;
        this.username = username;
    }
}
