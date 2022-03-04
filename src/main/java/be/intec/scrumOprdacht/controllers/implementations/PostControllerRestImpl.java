package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.PostController;
import be.intec.scrumOprdacht.models.Post;
import be.intec.scrumOprdacht.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("post")
public class PostControllerRestImpl  {

    private PostService postService;

    @Autowired
    public PostControllerRestImpl(PostService postService) {
        this.postService = postService;
    }


//    @GetMapping("/index")
//    public int getMostLikedPost() {
//        Page<Post> postsSortedByMostLikes = postService.getPostsPageSortedByMostLikes(1, 10);
//        return  postsSortedByMostLikes.getTotalPages();
//
//    }
//
//
//    @GetMapping("index")
//    public int showMostViewedPosts(Post post) {
//        Page<Post> postsSortedByMostViews = postService.getPostsPageSortedByMostViews(1, 10);
//       return  postsSortedByMostViews.getTotalPages();
//
//    }


    @GetMapping
    public List<Post> getPostsPageSorted(@RequestParam String criteria,@RequestParam int page, @RequestParam int size) {
        Page<Post> postPage = null;
        if("newest".equals(criteria)){
            postPage = postService.getPostsPageSortedByNewest(page, size);
        }else if("oldest".equals(criteria)){
            postPage = postService.getPostsPageSortedByOldest(page, size);
        }else {
            postPage = postService.getPostsPageSortedByMostViews(page, size);
        }
        List<Post> postList = postPage.stream().collect(Collectors.toList());
        return postList;
    }


//    @Override
//    @GetMapping("index")
//    public String showMostCommentedPosts(Post post) {
//        List<Post> postsSortedByMostComments = postService.getPostsPageSortedByMostComments();
//        postsSortedByMostComments.add(post);
//        return "index";
    //  }

}
