package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.UserController;
import be.intec.scrumOprdacht.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllerImpl implements UserController {


    private UserRepository userRepository;

    @GetMapping("home")
    public String hello1() {
        return "index";
    }

}
