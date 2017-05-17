package heroku_demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import heroku_demo.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
	
	List<Comment> findAll();

}
