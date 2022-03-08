package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer> {

    // SEARCH FUNCTION HEADER
//    @Query(value = "SELECT * FROM posts WHERE MATCH(title, body)AGAINST('\":keyword\"')", nativeQuery = true)
//    List<Post> search(@Param("keyword") String keyword);


    @Query(value = "select * from posts p where (p.title like %:keyword%) or (p.body like %:keyword%) ", nativeQuery = true)
    List<Post> search(@Param("keyword") String keyword);

    @Query(
            value = "select p from Post p " +
                    " Order By p.comments.size desc",
            countQuery = "select count(p) from Post p "
    )
    Page<Post> findAllWithCommentsCountDesc(Pageable pageable);
}
