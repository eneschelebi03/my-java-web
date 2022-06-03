package bg.softnui.sprinmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping("/hello/{id}/test")
    public String hello(Model model, @PathVariable("id") Integer id) {

        model.addAttribute("num", id);
        return "hellowworld";

    }
}
