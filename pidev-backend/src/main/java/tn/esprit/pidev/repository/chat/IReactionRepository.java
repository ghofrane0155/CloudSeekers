package tn.esprit.pidev.repository.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.entities.chat.Reaction;

public interface IReactionRepository extends JpaRepository<Reaction, Long> {
}
