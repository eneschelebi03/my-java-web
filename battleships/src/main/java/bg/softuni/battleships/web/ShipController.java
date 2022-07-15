package bg.softuni.battleships.web;

import bg.softuni.battleships.model.dto.AddShipDTO;
import bg.softuni.battleships.service.ShipService;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    private final ShipService shipService;
    private final LoggedUser loggerUser;

    public ShipController(ShipService shipService, LoggedUser loggerUser) {
        this.shipService = shipService;
        this.loggerUser = loggerUser;
    }

    @ModelAttribute("addShipDTO")
    public AddShipDTO addShipDTO() {
        return new AddShipDTO();
    }

    @GetMapping("/ships/add")
    public String addShip() {
        if (!loggerUser.isLogged()) {
            return "redirect:/home";
        }
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String addShip(@Valid AddShipDTO addShipDTO,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !this.shipService.addShip(addShipDTO)) {
            redirectAttributes.addFlashAttribute("addShipDTO", addShipDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.addShipDTO", bindingResult);

            return "redirect:/ships/add";
        }

        return "redirect:/home";
    }
}
