/**
 *
 */
package ua.clinic.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.clinic.jpa.Ugroup;
import ua.clinic.jpa.User;
import ua.clinic.jpa.Userdetails;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;

/**
 * @author Iryna Tkachova
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserdetailsRepository detailsRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        User u = userRepository.findOne(id);
        return u;
    }

    public List<User> findUserByName(String Name, String Surname) {
        List<Userdetails> udl = detailsRepository.findByNameAndSurname(Name, Surname);
        List<User> res = new ArrayList<>();
        udl.forEach((ud) -> {
            res.add(userRepository.findOne(ud.getIddetails()));
        });
        return res;
    }

    public User addUser(User au) {
        logger.debug("Adding users %s with id %s", au.getLogin(), au.getIduser());
        userRepository.save(au);
        return au;
    }

    public void delUser(Long id) {
        logger.info("ID>>> %s", id);
        User u = userRepository.findOne(id);
        if(u!=null){
            logger.debug("Deleting users %s with id %s", u.getLogin(), u.getIduser());
            List<Ugroup> gl = u.getUgroups();
            detailsRepository.delete(id);
            userRepository.delete(id);
        }
    }

}
