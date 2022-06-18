package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.LoginUserDTO;
import bg.softuni.mobilele.model.dto.RegisterUserDTO;
import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserMapper userMapper;


    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, CurrentUser currentUser, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
    }

    public boolean login(LoginUserDTO loginUserDTO) {

        Optional<UserEntity> user = userRepository
                .findByEmail(loginUserDTO.getUsername());

        if (user.isEmpty()) {
            LOGGER.debug("User with name [{}] is not found", loginUserDTO.getUsername());
            return false;
        }

        var rawPassword = loginUserDTO.getPassword();
        var encodedPassword = user.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(user.get());
        } else {
            logout();
        }

        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
        currentUser.setLogged(true);
        currentUser.setEmail(userEntity.getEmail());
    }

    public void logout() {
        currentUser.clear();
    }


    public void register(RegisterUserDTO registerDTO) {

        UserEntity newUser = userMapper.userRegisterDtoToUser(registerDTO)
                .setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        userRepository.save(newUser);
        login(newUser);
    }
}
