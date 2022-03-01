package be.intec.scrumOprdacht.controllers.implementations;

import be.intec.scrumOprdacht.controllers.interfaces.BlogController;
import be.intec.scrumOprdacht.models.Blog;
import be.intec.scrumOprdacht.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController("blogs")

public class BlogControllerImpl implements BlogController {

    private BlogService blogService;

    @Autowired
    public BlogControllerImpl(BlogService blogService) {
        this.blogService = blogService;
    }

//    @Override
//    @GetMapping("index")
//    public Blog getMostLikedBlog() {
//        Page<Blog> blogsSortedByMostLikes = blogService.getBlogsPageSortedByMostLikes(1, 10);
//        blogsSortedByMostLikes.getTotalPages();
//        return "index";
//    }
//
//    @Override
//    @GetMapping("index")
//    public String showMostViewedBlogs(Blog blog) {
//        Page<Blog> blogsSortedByMostViews = blogService.getBlogsPageSortedByMostViews(1, 10);
//        blogsSortedByMostViews.getTotalPages();
//        return "index";
//    }

    @Override
    @GetMapping
    public List<Blog> getBlogsPageSorted(@RequestParam String criteria,@RequestParam int page, @RequestParam int size) {
        Page<Blog> blogPage = null;
        if("newest".equals(criteria)){
            blogPage = blogService.getBlogsPageSortedByNewest(page, size);
        }else if("oldest".equals(criteria)){
            blogPage = blogService.getBlogsPageSortedByOldest(page, size);
        }else {
            blogPage = blogService.getBlogsPageSortedByMostViews(page, size);
        }
        List<Blog> blogList = blogPage.stream().collect(Collectors.toList());
        return blogList;
    }

//    @Override
//    @GetMapping("index")
//    public String showMostCommentedBlogs(Blog blog) {
//        List<Blog> blogsSortedByMostComments = blogService.getBlogsPageSortedByMostComments();
//        blogsSortedByMostComments.add(blog);
//        return "index";
    //  }

}