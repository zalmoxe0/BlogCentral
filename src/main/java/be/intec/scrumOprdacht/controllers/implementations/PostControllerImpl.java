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
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
public class PostControllerImpl implements PostController {

    private PostService postService;
    private UserService userService;

    @Autowired
    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }



    @Override
    @GetMapping("home")
    public String showPosts(Model model,@RequestParam Optional<String> criteria,@RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        String pageCriteria = criteria.orElse("newest");

        Page<Post> postPage = null;
        if("views".equals(pageCriteria)){
            postPage = postService.getPostsPageSortedByMostViews(currentPage-1,pageSize);
        }else if("oldest".equals(pageCriteria)){
            postPage = postService.getPostsPageSortedByOldest(currentPage-1,pageSize);
        }else {
            postPage = postService.getPostsPageSortedByNewest(currentPage-1,pageSize);
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
        model.addAttribute("mostLikedPost",mostLikedPost);

        Post mostViewedPost = postService.getMostViewedPost();
        model.addAttribute("mostViewedPost",mostViewedPost);

        Post mostCommentedPost = postService.getMostCommentedPost();
        model.addAttribute("mostCommentedPost",mostCommentedPost);


        return "index";
    }

    @Override
    @RequestMapping("/posts/view/{id}")
    public String viewPost(@PathVariable("id") Integer id, Model model) {
        Optional<Post> optionalPost = postService.getPostById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post",post);
        }else
        {
            model.addAttribute("error","Post not found!!!");
        }
        return "posts/view";
    }

    @Override
    @RequestMapping("/posts/like/{id}")
    public String likesPosts(@PathVariable("id") Integer id,Model model) {
        Optional<Post> optionalPost = postService.updateLikes(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            model.addAttribute("post",post);
        }else
        {
            model.addAttribute("error","Post not found!!!");
        }
        return "posts/like";
    }

    @Override
    @PostMapping("/posts/comment/add")
    public String addComment(Integer postId, Integer userId, String commentBody,String commentTitle, Model model) {
        Optional<Comment> optionalComment = postService.addComment(postId, userId, commentBody,commentTitle);
        if(optionalComment.isPresent()){
            Comment comment1 = optionalComment.get();
            Post post = comment1.getPost();
            model.addAttribute("post",post);
        }else
        {
            model.addAttribute("error","Comment not added(User or Post not found)!!!");
        }

        return "posts/view";
    }


    // SEARCH FUNCTION HEADER
    @GetMapping("/search")
    public String Search(@Param("keyword") String keyword, Model model){

        List<Post> searchResult = postService.search(keyword);

        model.addAttribute("keyword", keyword);
        model.addAttribute("pageTitle", "Search result for: '" + keyword + "'");
        model.addAttribute("searchResult", searchResult);

        return "searchresults";

    }


}
