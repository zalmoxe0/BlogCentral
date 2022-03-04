package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer> {

    // SEARCH FUNCTION HEADER
    @Query(value = "SELECT * FROM posts p WHERE p.title LIKE :keyword" , nativeQuery = true)
    List<Post> findByKeyword(@Param("keyword") String keyword);

}
