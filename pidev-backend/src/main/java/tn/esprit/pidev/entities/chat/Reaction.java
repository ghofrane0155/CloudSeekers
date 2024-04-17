package tn.esprit.pidev.entities.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.pidev.entities.user.User;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {
    @Id
    @GeneratedValue
    private Long id;
    private String reaction;
    private LocalDateTime dateReact;;
    @ManyToOne
    private User user;
    @ManyToOne
    @JsonIgnore
    private Message message;
    private boolean archived;

    @Override
    public String toString() {
        return "React{" +
                "id=" + id +
                ", reaction='" + reaction + '\'' +
                ", dateReact=" + dateReact +
                ", user=" + user +
                ", message=" + message +
                ", archived=" + archived +
                '}';
    }
}
