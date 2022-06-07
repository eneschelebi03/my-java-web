package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.LoginUserDTO;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(LoginUserDTO loginUserDTO) {

        Optional<UserEntity> user = userRepository
                .findByEmail(loginUserDTO.getUsername());

        if (user.isEmpty()) {
            LOGGER.debug("User with name [{}] is not found", loginUserDTO.getUsername());
            return false;
        }

        return loginUserDTO.getPassword().equals(user.get().getPassword());
    }
}
