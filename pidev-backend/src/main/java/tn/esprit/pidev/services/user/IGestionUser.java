package tn.esprit.pidev.services.user;

import tn.esprit.pidev.entities.user.User;

import java.util.List;
import java.util.Optional;

public interface IGestionUser {
    List<User> getAll();
    User add(User user);
    User update(User user);
    User getById (Long id);

    //forum
    Optional<User> getUserByEmail(String email);
}
