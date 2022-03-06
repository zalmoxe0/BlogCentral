package be.intec.scrumOprdacht.controllers.interfaces;

import be.intec.scrumOprdacht.models.Comment;
import be.intec.scrumOprdacht.models.Post;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

public interface PostController {

   // List<Post> getPostsPageSorted(String criteria,int page, int size);
    //List<Post> getPostsPageSortedByOldest(int page, int size);
   // String showNewestPosts(Model model);
   // String showOldestPosts(Model model);
   // String showPapularPosts(Model model, Optional<Integer> page, Optional<Integer> size);
   String showPosts(Model model,Optional<String> criteria, Optional<Integer> page, Optional<Integer> size);
   // String showOldestPosts(Model model, Optional<Integer> page, Optional<Integer> size);
   //String showMostLikedPost();
   //int showMostCommentedPost();
  // String showPosts(Post post);

   String viewPost(Integer id,Model model);
   String likesPosts(Integer id,Model model);
   String addComment(Integer postId,Integer userId,String commentBody,String commentTitle,Model model);

//   String createNewPost(Post post);
//   String deletePost(Integer id, Principal principal);





}
