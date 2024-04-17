package tn.esprit.pidev.repository.forum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pidev.entities.forum.Post;
import tn.esprit.pidev.entities.forum.Subforum;
import tn.esprit.pidev.entities.user.User;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubforum(Subforum subforum);

    List<Post> findByUser(User user);


}
