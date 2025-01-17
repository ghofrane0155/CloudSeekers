package tn.esprit.pidev.entities.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.pidev.entities.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private LocalDateTime dateSent;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ;
    private LocalDateTime dateModified;
    @ManyToOne
    private User user;
    @ManyToOne
    private Discussion discussion;
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "message")
    private List<Reaction> reactions = new ArrayList<Reaction>();
    @OneToOne
    private Message reply = null;
    private boolean archived;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", dateSent=" + dateSent +
                ", dateModified=" + dateModified +
                ", user=" + user +
                ", discussion=" + discussion +
                ", archived=" + archived +
                '}';
    }
}
