package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.service.AuthService;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final AuthService authService;
    private final SongService songService;
    private UserService userService;

    public HomeController(AuthService authService, SongService songService, UserService userService) {
        this.authService = authService;
        this.songService = songService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (!this.authService.isLogged()) {
            return "index";
        }

        List<Song> popSongs = this.songService.getPopSongs();
        model.addAttribute("popSongs", popSongs);

        List<Song> rockSongs = this.songService.getRockSongs();
        model.addAttribute("rockSongs", rockSongs);

        List<Song> jazzSongs = this.songService.getJazzSongs();
        model.addAttribute("jazzSongs", jazzSongs);

        List<Song> userSongs = this.userService.getUserSongs();
        model.addAttribute("userSongs", userSongs);


        return "home";
    }


}
