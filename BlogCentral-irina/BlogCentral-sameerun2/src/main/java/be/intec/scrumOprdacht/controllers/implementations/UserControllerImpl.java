package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.IUserController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllerImpl implements IUserController {

    @GetMapping("home")
    public String hello1() {

        return "index";
    }

}
