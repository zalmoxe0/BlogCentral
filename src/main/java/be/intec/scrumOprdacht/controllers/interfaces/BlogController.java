package be.intec.scrumOprdacht.controllers.interfaces;

import be.intec.scrumOprdacht.models.Blog;

import java.util.List;

public interface BlogController {

    //Blog getMostLikedBlog();
    //Blog getMostViewedBlog();
    //Blog showMostCommentedBlog();
    List<Blog> getBlogsPageSorted(String criteria,int page, int size);
    //List<Blog> getBlogsPageSortedByOldest(int page, int size);





}
