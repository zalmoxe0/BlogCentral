package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.PostController;
import be.intec.scrumOprdacht.models.Post;
import be.intec.scrumOprdacht.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PostControllerImpl implements PostController {

    private PostService postService;

    @Autowired
    public PostControllerImpl(PostService postService) {
        this.postService = postService;
    }

//    @Override
//    @GetMapping("index")
//    public Post getMostLikedPost() {
//        Page<Post> postsSortedByMostLikes = postService.getPostPageSortedByMostLikes(1,1);
//        postsSortedByMostLikes.getTotalElements();
//        return "index";
//    }

//    @Override
//    @GetMapping("index")
//    public String showMostViewedBlogs(Blog blog) {
//        Page<Blog> blogsSortedByMostViews = blogService.getBlogsPageSortedByMostViews(1, 10);
//        blogsSortedByMostViews.getTotalPages();
//        return "index";
//    }

//    @Override
//    @GetMapping
//    public List<Post> getBlogsPageSorted(@RequestParam String criteria,@RequestParam int page, @RequestParam int size) {
//        Page<Post> postPage = null;
//        if("newest".equals(criteria)){
//            postPage = postService.getPostPageSortedByNewest(page, size);
//        }else if("oldest".equals(criteria)){
//            postPage = postService.getPostPageSortedByOldest(page, size);
//        }else {
//            postPage = postService.getPostPageSortedByMostViews(page, size);
//        }
//        List<Post> postList = postPage.stream().collect(Collectors.toList());
//        return postList;
//    }

//    @Override
//    @GetMapping("index")
//    public String showMostCommentedBlogs(Blog blog) {
//        List<Blog> blogsSortedByMostComments = blogService.getBlogsPageSortedByMostComments();
//        blogsSortedByMostComments.add(blog);
//        return "index";
//  }

    @GetMapping("home")
    public String showBlogs(Model model) {
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "index";
    }

    // SEARCH FUNCTION HEADER
    @GetMapping(path = {"/","/search"})
    public String home(Model model, String keyword) {
        if(keyword != null) {
            List<Post> list = postService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Post> list = postService.getPosts();
            model.addAttribute("list", list);
          }
        return "index";
    }

}
