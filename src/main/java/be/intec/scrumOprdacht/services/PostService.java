package be.intec.scrumOprdacht.services;

import be.intec.scrumOprdacht.models.Comment;
import be.intec.scrumOprdacht.models.Post;
import be.intec.scrumOprdacht.models.User;
import be.intec.scrumOprdacht.repositories.CommentRepository;
import be.intec.scrumOprdacht.repositories.PostRepository;
import be.intec.scrumOprdacht.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    // without Pagination

    public List<Post> getPostsSortedByNewest(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"creation"));
    }
    public List<Post> getPostsSortedByOldest(){
        return postRepository.findAll(Sort.by(Sort.Direction.ASC,"creation"));
    }
    public List<Post> getPostsSortedByMostViews(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"views"));
    }

    public List<Post> getPostsSortedByMostLikes(){
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"likes"));
    }


    // with Pagination

    public Page<Post> getPostsPageSortedByNewest(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("creation").descending());
        return postRepository.findAll(postsWithPages);
    }

    public Page<Post> getPostsPageSortedByOldest(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("creation").ascending());
        return postRepository.findAll(postsWithPages);
    }

    public Page<Post> getPostsPageSortedByMostViews(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("views").descending());
        return postRepository.findAll(postsWithPages);
    }

    public Page<Post> getPostsPageSortedByMostLikes(int page, int size){
        Pageable postsWithPages = PageRequest.of(page,size, Sort.by("likes").descending());
        return postRepository.findAll(postsWithPages);
    }

    private Page<Post> getPostsPageSortedByMostComments(int page, int size) {
        Pageable postsWithPages = PageRequest.of(page,size);
        return postRepository.findAllWithCommentsCountDesc(postsWithPages);
    }


    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }

    public Optional<Post> getPostById(Integer id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            long updatedViews = post.getViews() + 1;
            post.setViews(updatedViews);
            postRepository.save(post);
        }
        return optionalPost;
    }

    public Optional<Post> updateLikes(Integer id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            long updatedLikes = post.getLikes() + 1;
            post.setLikes(updatedLikes);
            postRepository.save(post);
        }
        return optionalPost;
    }

    public Optional<Comment> addComment(Integer postId,Integer userId,String commentBody,String commentTitle){
        Optional<Post> optionalPost = postRepository.findById(postId);
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalPost.isPresent() && optionalUser.isPresent()){
            Post post = optionalPost.get();
            User user = optionalUser.get();
            Comment comment =new Comment();
            comment.setBody(commentBody);
            comment.setTitle(commentTitle);
            comment.setCreation(Timestamp.valueOf(LocalDateTime.now()));
            comment.setPost(post);
            comment.setUserName(user.getUserName());
            comment.setUser(user);
            Comment savedComment = commentRepository.save(comment);
            return Optional.of(savedComment);
        }
        return Optional.empty();
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }


    public Post getMostLikedPost() {
        Page<Post> postPage = getPostsPageSortedByMostLikes(0, 1);
        return postPage.toList().get(0);
    }

    public Post getMostViewedPost() {
        Page<Post> postPage = getPostsPageSortedByMostViews(0, 1);
        return postPage.toList().get(0);
    }

    public Post getMostCommentedPost() {
        Page<Post> postPage = getPostsPageSortedByMostComments(0, 1);
        return postPage.toList().get(0);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    //SEARCH FUNCTION HEADER
    public List<Post> search(String keyword) {
        return postRepository.search(keyword);
    }


}
