package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dto.BattleShipDTO;
import bg.softuni.battleships.model.dto.ShipDTO;
import bg.softuni.battleships.service.ShipService;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    private final ShipService shipService;
    private final LoggedUser loggerUser;

    public HomeController(ShipService shipService, LoggedUser loggerUser) {
        this.shipService = shipService;
        this.loggerUser = loggerUser;
    }

    @ModelAttribute("battleShipDTO")
    public BattleShipDTO battleShipDTO() {
        return new BattleShipDTO();
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        if (loggerUser.isLogged()) {
            return "redirect:/home";
        }
        return "index";
    }


    @GetMapping("/home")
    public String chooseShips(Model model) {
        if (!loggerUser.isLogged()) {
            return "redirect:/";
        }

        List<ShipDTO> ownedShips = this.shipService.getOwnedShips();
        List<ShipDTO> enemyShips = this.shipService.getEnemyShips();
        List<ShipDTO> allSortedShips = this.shipService.getAllSortedShips();

        model.addAttribute("ownedShips", ownedShips);
        model.addAttribute("enemyShips", enemyShips);
        model.addAttribute("allSortedShips", allSortedShips);

        return "home";
    }

}
