package tn.esprit.pidev.repository.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.pidev.entities.chat.Discussion;
import tn.esprit.pidev.entities.chat.TypeDiscussion;
import tn.esprit.pidev.entities.user.User;

import java.util.List;

public interface IDiscussionRepository extends JpaRepository<Discussion, Long> {

    List<Discussion> findByUsersContainingAndArchivedIsFalseAndTypeDiscussionIsNot(User user, TypeDiscussion typeDiscussion);

    List<Discussion> findByUsersContainingAndArchivedIsFalseAndTypeDiscussionIs(User user, TypeDiscussion typeDiscussion);

}
