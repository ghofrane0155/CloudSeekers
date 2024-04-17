package tn.esprit.pidev.services.user;

import tn.esprit.pidev.entities.user.User;

import java.util.List;

public interface IGestionUser {
    List<User> getAll();
    User add(User user);
    User update(User user);
    User getById (Long id);
}
