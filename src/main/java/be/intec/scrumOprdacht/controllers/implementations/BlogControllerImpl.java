package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.BlogController;
import be.intec.scrumOprdacht.models.Post;
import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.services.PostService;
import be.intec.scrumOprdacht.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogControllerImpl implements BlogController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public BlogControllerImpl(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    @RequestMapping(value = "/bloghome/{username}", method = RequestMethod.GET)
    public String blogForUsername(@PathVariable String username,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size, Model model) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);

        Optional<User> optionalUser = userService.getByUserName(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Page<Post> posts = postService.getPostsByUserOrderByCreation(user, currentPage, pageSize);

            model.addAttribute("posts", posts);
            model.addAttribute("user", user);

            return "bloghome";
        } else {
            return "error";
        }
    }
}
