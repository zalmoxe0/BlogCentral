package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.UserController;
import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class UserControllerImpl implements UserController {

    private UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    @GetMapping("login")
    public String goToLoginPage(Model model, HttpSession httpSession) {

        if (httpSession.getAttribute("loggedInUser") == null) {
            model.addAttribute("user", new User("", ""));

            return "login";

        } else {

            return "redirect:home";

        }

    }


    @Override
    @PostMapping("login")
    public String Login(@ModelAttribute("user") User userReceived, HttpSession httpSession) {

        System.out.println(userReceived.getUserName());
        System.out.println(userReceived.getPassCode());

        User foundUser = userService.getUserByPassWordAndUserName(userReceived.getUserName(), userReceived.getPassCode());

        if(foundUser == null) {

            System.out.println("no valid credentials");
            return "redirect:login";

        } else {

            httpSession.setAttribute("loggedInUser", userReceived.getUserName());
            return "redirect:home";

        }

    }


    @PostMapping("logout")
    public String logout(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("loggedInUser") != null) {

            model.addAttribute("user", new User("", ""));
            return "home";

        } else {

            httpSession.setAttribute("loggedInUser", null);
            return "redirect:login";

        }

    }

}
