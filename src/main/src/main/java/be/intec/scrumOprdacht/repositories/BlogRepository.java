package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository <Blog, Integer> {
}
