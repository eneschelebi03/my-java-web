package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.LoginUserDTO;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {

        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login (LoginUserDTO loginUserDTO) {



        System.out.println("User is logged: " + userService.login(loginUserDTO));

        return "redirect:/";
    }
}
