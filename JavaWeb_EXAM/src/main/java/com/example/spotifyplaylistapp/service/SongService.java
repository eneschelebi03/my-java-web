package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.mapper.SongMapper;
import com.example.spotifyplaylistapp.model.dto.AddSongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.enums.StyleType;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {


    private final SongRepository songRepository;
    private final SongMapper songMapper;
    private final StyleRepository styleRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    public SongService(SongRepository songRepository, SongMapper songMapper, StyleRepository styleRepository, UserRepository userRepository, AuthService authService) {
        this.songRepository = songRepository;
        this.songMapper = songMapper;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;
        this.authService = authService;
    }

    public boolean addSong(AddSongDTO addSongDTO) {

        Optional<Song> byTitle = this.songRepository.findByPerformer(addSongDTO.getPerformer());

        if (byTitle.isPresent()) {
            return false;
        }

        Song song = this.songMapper.addSongDtoToSong(addSongDTO);

        Style style = this.styleRepository.findByName(StyleType.valueOf(addSongDTO.getStyle()));
        song.setStyle(style);

        this.songRepository.save(song);

        return true;
    }

    public List<Song> getPopSongs() {
        Style style = this.styleRepository.findByName(StyleType.valueOf("POP"));
        return this.songRepository.findByStyle(style);
    }

    public List<Song> getRockSongs() {
        Style style = this.styleRepository.findByName(StyleType.valueOf("ROCK"));
        return this.songRepository.findByStyle(style);
    }

    public List<Song> getJazzSongs() {
        Style style = this.styleRepository.findByName(StyleType.valueOf("JAZZ"));
        return this.songRepository.findByStyle(style);
    }
}
