package be.intec.scrumOprdacht.repositories;

import be.intec.scrumOprdacht.models.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Integer> {
}
