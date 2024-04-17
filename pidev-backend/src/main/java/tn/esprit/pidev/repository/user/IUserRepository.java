package tn.esprit.pidev.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.entities.user.User;

public interface IUserRepository extends JpaRepository<User, Long> {
}
