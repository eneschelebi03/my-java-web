package bg.softuni.mobilele.web;

import bg.softuni.mobilele.model.dto.LoginUserDTO;
import bg.softuni.mobilele.model.dto.RegisterUserDTO;
import bg.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserLoginController {
    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {

        return "auth-login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();

        return "redirect:/";
    }


    @PostMapping("/login")
    public String login (LoginUserDTO loginUserDTO) {

        userService.login(loginUserDTO);

        return "redirect:/";
    }
}
