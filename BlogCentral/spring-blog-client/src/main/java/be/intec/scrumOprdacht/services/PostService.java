package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.Post;
import be.intec.scrumOprdacht.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    // SEARCH FUNCTION HEADER
    public List<Post> getByKeyword(String keyword){
        return postRepository.findByKeyword(keyword);
    }


    // without Pagination

    public List<Post> getPostSortedByNewest(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"creationDate"));
    }
    public List<Post> getPostSortedByOldest(){
        return postRepository.findAll(Sort.by(Sort.Direction.ASC,"creationDate"));
    }
    public List<Post> getPostSortedByMostViews(){
        return postRepository.findAll(Sort.by("views"));
    }

    public List<Post> getPostSortedByMostLikes(){
        return postRepository.findAll(Sort.by("likes"));
    }


    // with Pagination

    public Page<Post> getPostPageSortedByNewest(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("creation").descending());
        return postRepository.findAll(postsWithPages);
    }

    public Page<Post> getPostPageSortedByOldest(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("creation").ascending());
        return postRepository.findAll(postsWithPages);
    }

    public Page<Post> getPostPageSortedByMostViews(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("views").descending());
        return postRepository.findAll(postsWithPages);
    }

    public Page<Post> getPostPageSortedByMostLikes(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("likes").descending());
        return postRepository.findAll(postsWithPages);
    }


}
