package bg.softuni.demo.web

import bg.softuni.demo.service.GreetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class GreetController(val greetService : GreetService)  {

    @GetMapping("/greet")
    fun greet(@RequestParam(name = "name") name : String,
              model : Model) : String {

        model.addAttribute("greeting", greetService.generateGreeting(name))

        return "greet";
    }
}