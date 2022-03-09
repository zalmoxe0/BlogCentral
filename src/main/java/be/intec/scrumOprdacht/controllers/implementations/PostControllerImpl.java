package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.PostController;
import be.intec.scrumOprdacht.models.Comment;
import be.intec.scrumOprdacht.models.Post;
import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.services.PostService;
import be.intec.scrumOprdacht.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.validation.Valid;


@Controller
public class PostControllerImpl implements PostController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public PostControllerImpl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @Override
    @GetMapping("home")
    public String showPosts(Model model, @RequestParam Optional<String> criteria, @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        String pageCriteria = criteria.orElse("newest");

        Page<Post> postPage = null;
        if ("views".equals(pageCriteria)) {
            postPage = postService.getPostsPageSortedByMostViews(currentPage - 1, pageSize);
        } else if ("oldest".equals(pageCriteria)) {
            postPage = postService.getPostsPageSortedByOldest(currentPage - 1, pageSize);
        } else {
            postPage = postService.getPostsPageSortedByNewest(currentPage - 1, pageSize);
        }

        model.addAttribute("postPage", postPage);

        int totalPages = postPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        Post mostLikedPost = postService.getMostLikedPost();
        model.addAttribute("mostLikedPost", mostLikedPost);

        Post mostViewedPost = postService.getMostViewedPost();
        model.addAttribute("mostViewedPost", mostViewedPost);

        Post mostCommentedPost = postService.getMostCommentedPost();
        model.addAttribute("mostCommentedPost", mostCommentedPost);


        return "index";
    }

    @Override
    @RequestMapping("/posts/view/{id}")
    public String viewPost(@PathVariable("id") Integer id, Model model) {
        Optional<Post> optionalPost = postService.getPostById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
        } else {
            model.addAttribute("error", "Post not found!!!");
        }
        return "posts/view";
    }

    @Override
    @RequestMapping("/posts/like/{id}")
    public String likesPosts(@PathVariable("id") Integer id, Model model) {
        Optional<Post> optionalPost = postService.updateLikes(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
        } else {
            model.addAttribute("error", "Post not found!!!");
        }
        return "posts/like";
    }

    @Override
    @PostMapping("/posts/comment/add")
    public String addComment(Integer postId, Integer userId, String commentBody, String commentTitle, Model model) {
        Optional<Comment> optionalComment = postService.addComment(postId, userId, commentBody, commentTitle);
        if (optionalComment.isPresent()) {
            Comment comment1 = optionalComment.get();
            Post post = comment1.getPost();
            model.addAttribute("post", post);
        } else {
            model.addAttribute("error", "Comment not added(User or Post not found)!!!");
        }

        return "posts/view";
    }

    // post related methods

    @Override
    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String newPost(Principal principal, Model model) {

        Optional<User> user = userService.findByUsername(principal.getName());
        if (user.isPresent()) {
            Post post = new Post();
            post.setOwner(user.get());

            model.addAttribute("post", post);

            return "/newpost";
        }else {
            return "/error";
        }
    }

    @Override
    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String createNewPost(@Valid Post post,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/newpost";
        } else {
            postService.createPost(post);
            return "redirect:/view/" + post.getOwner().getUserName();
        }
    }

    @Override
    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.GET)
    public String editPostWithId(@PathVariable Integer id,
                                 Principal principal,
                                 Model model) {

        Optional<Post> optionalPost = postService.getPostById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("post", post);
                return "/newpost";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }

    @Override
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String getPostWithId(Integer id, Principal principal, Model model) {

        Optional<Post> optionalPost = postService.getPostById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            model.addAttribute("post", post);
            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("username", principal.getName());
            }

            return "/view";

        } else {
            return "/error";
        }
    }

    @Override
    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Integer id,
                                   Principal principal) {

        Optional<Post> optionalPost = postService.getPostById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isPrincipalOwnerOfPost(principal, post)) {
                postService.deletePost(post);
                return "redirect:/index";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }


    // SEARCH FUNCTION HEADER
    @GetMapping("/search")
    public String Search(@Param("keyword") String keyword, Model model) {

        List<Post> searchResult = postService.search(keyword);

        model.addAttribute("keyword", keyword);
        model.addAttribute("pageTitle", "Search result for: '" + keyword + "'");
        model.addAttribute("searchResult", searchResult);

        return "searchresults";

    }

    private boolean isPrincipalOwnerOfPost(Principal principal, Post post) {
        return principal != null && principal.getName().equals(post.getOwner().getUserName());
    }

}
