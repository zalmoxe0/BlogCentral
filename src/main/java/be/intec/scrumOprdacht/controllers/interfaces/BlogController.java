package be.intec.scrumOprdacht.controllers.interfaces;

import org.springframework.ui.Model;

import java.util.Optional;


public interface BlogController {

    String blogForUsername(String username, Optional<Integer> page, Optional<Integer> size, Model model);
}
