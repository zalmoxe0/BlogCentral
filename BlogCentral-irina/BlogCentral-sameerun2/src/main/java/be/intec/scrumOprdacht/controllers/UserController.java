package be.intec.scrumOprdacht.controllers;

import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String userMain(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user-main";
    }

    @GetMapping("/user/add")
    public String userAdd(Model model){
        return "user-add";
    }

}
