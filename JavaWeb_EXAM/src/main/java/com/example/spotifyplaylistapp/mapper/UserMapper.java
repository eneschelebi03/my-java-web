package com.example.spotifyplaylistapp.mapper;

import com.example.spotifyplaylistapp.model.dto.LoginDTO;
import com.example.spotifyplaylistapp.model.dto.RegisterDTO;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.session.LoggedUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User loginDtoToUser(LoginDTO loginDTO);

    User registerDtoToUser(RegisterDTO registerDTO);
}
