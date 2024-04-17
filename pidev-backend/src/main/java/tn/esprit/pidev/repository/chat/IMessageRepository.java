package tn.esprit.pidev.repository.chat;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.entities.chat.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface IMessageRepository extends JpaRepository<Message, Long> {
    List<Message> findTop20ByDiscussionIdOrderByDateSent(Long id);

    List<Message> findAllByDiscussionIdAndArchivedIsFalseOrderByDateSent(Long id);

    List<Message> findByDiscussionIdOrderByDateSent(Long id, Pageable pageable);


    List<Message> findByDiscussionIdAndDateSentAfterOrderByDateSent(Long id, LocalDateTime recentDateo);

}
