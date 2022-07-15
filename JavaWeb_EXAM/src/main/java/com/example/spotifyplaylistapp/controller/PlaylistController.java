package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlaylistController {

    private UserService userService;

    public PlaylistController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/addToPlaylist/{id}")
    public String addToPlaylist(@PathVariable long id) {
        this.userService.addToPlaylist(id);
        return "redirect:/";
    }
}
