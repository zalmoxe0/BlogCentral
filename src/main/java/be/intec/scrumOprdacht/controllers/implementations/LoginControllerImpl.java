package be.intec.scrumOprdacht.controllers.implementations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginControllerImpl {
    @GetMapping("/login")
    public String login(Principal principal) {

        if (principal != null) {
            return "redirect:/home";
        }
        return "/login";
    }
}
