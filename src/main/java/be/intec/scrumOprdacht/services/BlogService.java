package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.Blog;
import be.intec.scrumOprdacht.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    // without Pagination

    public List<Blog> getBlogsSortedByNewest(){
        return blogRepository.findAll(Sort.by(Sort.Direction.DESC,"creationDate"));
    }
    public List<Blog> getBlogsSortedByOldest(){
        return blogRepository.findAll(Sort.by(Sort.Direction.ASC,"creationDate"));
    }
    public List<Blog> getBlogsSortedByMostViews(){
        return blogRepository.findAll(Sort.by("views"));
    }

    public List<Blog> getBlogsSortedByMostLikes(){
        return blogRepository.findAll(Sort.by("likes"));
    }


    // with Pagination

    public Page<Blog> getBlogsPageSortedByNewest(int page, int size){
        Pageable blogsWithPages = PageRequest.of(page,size, Sort.by("creationDate").descending());
        return blogRepository.findAll(blogsWithPages);
    }

    public Page<Blog> getBlogsPageSortedByOldest(int page, int size){
        Pageable blogsWithPages = PageRequest.of(page,size, Sort.by("creationDate").ascending());
        return blogRepository.findAll(blogsWithPages);
    }

    public Page<Blog> getBlogsPageSortedByMostViews(int page, int size){
        Pageable blogsWithPages = PageRequest.of(page,size, Sort.by("views").descending());
        return blogRepository.findAll(blogsWithPages);
    }

    public Page<Blog> getBlogsPageSortedByMostLikes(int page, int size){
        Pageable blogsWithPages = PageRequest.of(page,size, Sort.by("likes").descending());
        return blogRepository.findAll(blogsWithPages);
    }





}
