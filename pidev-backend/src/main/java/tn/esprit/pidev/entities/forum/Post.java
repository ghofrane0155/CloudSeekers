package tn.esprit.pidev.entities.forum;

import jakarta.persistence.*;
import lombok.*;
import tn.esprit.pidev.entities.user.User;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String postName;
    private String url;
    @Lob
    private String description;
    private Integer voteCount = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "subforum_id", referencedColumnName = "id")
    private Subforum subforum;
}
