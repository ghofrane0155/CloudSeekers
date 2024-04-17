package tn.esprit.pidev.services.chat;

import tn.esprit.pidev.entities.chat.Reaction;

public interface IGestionReaction {

    public Reaction addReaction (Integer user, Long message, String reaction);

    public boolean deleteReaction (Long id);

}
