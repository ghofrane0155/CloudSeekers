package tn.esprit.pidev.services.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entities.chat.Discussion;
import tn.esprit.pidev.entities.chat.Message;
import tn.esprit.pidev.repository.chat.IDiscussionRepository;
import tn.esprit.pidev.repository.chat.IMessageRepository;
import tn.esprit.pidev.repository.user.IUserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class GestionMessageImpl implements IGestionMessage {
    @Autowired
    IMessageRepository iMessageRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    IDiscussionRepository iDiscussionRepository;
    @Override
    public Message sendMessage(Long userSender, Long discussion, String message) {
        Message messageo = new Message();
        messageo.setMessage(message);



        messageo.setDateSent(LocalDateTime.now());
        messageo.setArchived(false);
        messageo.setUser(iUserRepository.findById(userSender).get());

        Discussion discussiono = iDiscussionRepository.findById(discussion).get();
        messageo.setDiscussion(discussiono);

        return iMessageRepository.save(messageo);
    }

    public Message modifyMessage(Long id, String message) {
        Message messageo = iMessageRepository.findById(id).get();
        messageo.setDateModified(LocalDateTime.now());
        messageo.setMessage(message);
        return iMessageRepository.save(messageo);
    }

    public boolean deleteMessage(Long id) {
        Message message = iMessageRepository.findById(id).get();
        message.setArchived(true);
        try {
            iMessageRepository.save(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Message replyMessage(Long userSender, Long discussion,Long message, String reply) {
        Message messageo = new Message();
        messageo.setMessage(reply);
        messageo.setDateSent(LocalDateTime.now());
        messageo.setArchived(false);
        messageo.setUser(iUserRepository.findById(userSender).get());
        messageo.setReply(iMessageRepository.findById(message).get());

        Discussion discussiono = iDiscussionRepository.findById(discussion).get();
        messageo.setDiscussion(discussiono);

        return iMessageRepository.save(messageo);
    }

    public List<Message> retrieveAllMessages(Long id){
        return iMessageRepository.findAllByDiscussionIdAndArchivedIsFalseOrderByDateSent(id);
    }

    public List<Message> retrieve20Messages(Long id){
        return iMessageRepository.findTop20ByDiscussionIdOrderByDateSent(id);
    }

    public List<Message> retrieveA20Messages(Long id, int pageNumber) {
        int pageSize = 20;
        int offset = pageNumber * pageSize;
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by("DateSent"));
        return iMessageRepository.findByDiscussionIdOrderByDateSent(id, pageable);
    }

    public List<Message> retrieveRecentMessages(Long id, String recentDate)
    {
        LocalDateTime recentDateo = LocalDateTime.parse(recentDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS"));
        return iMessageRepository.findByDiscussionIdAndDateSentAfterOrderByDateSent(id, recentDateo);
    }



}
