package tn.esprit.pidev.entities.evaluation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.pidev.entities.user.User;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reponse implements Serializable {
    @Id
    @GeneratedValue
    private Long numReponse;
    private String selectedChoice;

    @ManyToOne
    private User user;
    @ManyToOne
    private Question question;

}
