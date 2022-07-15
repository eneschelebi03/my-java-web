package com.example.spotifyplaylistapp.mapper;

import com.example.spotifyplaylistapp.model.dto.AddSongDTO;
import com.example.spotifyplaylistapp.model.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {

    @Mapping(target = "style", ignore = true)
    Song addSongDtoToSong(AddSongDTO addSongDTO);
}
