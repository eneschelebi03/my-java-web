package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.mapper.UserMapper;
import com.example.spotifyplaylistapp.model.dto.LoginDTO;
import com.example.spotifyplaylistapp.model.dto.RegisterDTO;
import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final LoggedUser loggedUser;

    public AuthService(UserRepository userRepository, UserMapper userMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.loggedUser = loggedUser;
    }

    public boolean register(RegisterDTO registerDTO) {

        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> userExist = this.userRepository.findByUsername(registerDTO.getUsername());

        if (userExist.isPresent()) {
            return false;
        }

        User newUser = this.userMapper.registerDtoToUser(registerDTO);

        this.userRepository.save(newUser);

        return true;

    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> byUsername = this.userRepository.findByUsername(loginDTO.getUsername());

        if (byUsername.isEmpty()) {
            return false;
        }

        User user = byUsername.get();

        if (!loginDTO.getPassword().equals(user.getPassword())) {
            return false;
        }

        this.loggedUser.login(user.getId(), user.getUsername());

        return true;

    }

    public void logout() {
        this.loggedUser.clear();
    }

    public boolean isLogged() {

        return this.loggedUser.getId() != 0;
    }

    public long getLoggedId() {
        return this.loggedUser.getId();
    }
}
