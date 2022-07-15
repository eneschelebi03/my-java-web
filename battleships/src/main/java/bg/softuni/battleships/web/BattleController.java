package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dto.BattleShipDTO;
import bg.softuni.battleships.service.BattleService;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BattleController {


    private final BattleService battleService;
    private final LoggedUser loggedUser;

    public BattleController(BattleService battleService, LoggedUser loggedUser) {
        this.battleService = battleService;
        this.loggedUser = loggedUser;
    }

    @PostMapping("/ships/battle")
    public String battle(@Valid BattleShipDTO battleShipDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        if (loggedUser.isLogged()) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("battleShipDTO", battleShipDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.battleShipDTO", bindingResult);

            return "redirect:/home";
        }

        this.battleService.attack(battleShipDTO);

        return "redirect:/home";
    }
}
