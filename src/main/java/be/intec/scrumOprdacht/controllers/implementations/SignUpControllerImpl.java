package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.SignUpController;
import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SignUpControllerImpl implements SignUpController {

    private final UserService userService;

    @Autowired
    public SignUpControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "/signup";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {

        if (userService.getByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (userService.getByUserName(user.getUserName()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        if (!bindingResult.hasErrors()) {
            // Registration successful, save user
            // Set user role to USER and set it as active
            userService.createSave(user);

            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("user", new User());
        }

        return "/signup";
    }
}
