package tn.esprit.pidev.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entities.user.User;
import tn.esprit.pidev.repository.user.IUserRepository;

import java.util.List;

@Service
public class GestionUserImpl implements IGestionUser{
    @Autowired
    IUserRepository ur;
    @Override
    public List<User> getAll(){return ur.findAll();}
    @Override
    public User add(User user){return ur.save(user);}
    @Override
    public  User update(User user){return ur.save(user);}
    @Override
    public User getById(Long id){return ur.getById(id);}

}
