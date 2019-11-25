package tmmdl.crudservice.restcontroller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/welcome")
    public String welcome(Model model){

        model.addAttribute("welcome");

        return "welcome";

    }

    public String sendig(Model model){

        model.addAttribute("sending");

        return "sending";
    }
}
