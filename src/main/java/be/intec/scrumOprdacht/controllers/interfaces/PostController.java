package be.intec.scrumOprdacht.controllers.interfaces;

import be.intec.scrumOprdacht.models.Comment;
import be.intec.scrumOprdacht.models.Post;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
public interface PostController {

    String showPosts(Model model,Optional<String> criteria, Optional<Integer> page, Optional<Integer> size);
    String viewPost(Integer id,Model model);
    String likesPosts(Integer id,Model model);
    String addComment(Integer postId,Integer userId,String commentBody,String commentTitle,Model model);

    String newPost(Principal principal,Model model);
    String createNewPost(Post post,BindingResult bindingResult);
    String editPostWithId(Integer id,Principal principal,Model model);
    String getPostWithId(Integer id,Principal principal,Model model);
    String deletePostWithId(Integer id,Principal principal);

 }
