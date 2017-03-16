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

import ua.clinic.jpa.Group;
import ua.clinic.jpa.User;
import ua.clinic.jpa.Userdetails;
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;
import ua.clinic.utils.IdGenerator;

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
    @Autowired
    UgroupRepository ugroupRepository;

    public User newUser(User inData) {
        Long newId;
        do {
            newId = IdGenerator.newId();
        } while(userRepository.findOne(newId) != null);
        inData.setIduser(newId);

        Group group = ugroupRepository.findByGroupname("guest");
        List<User> users = group.getUsers();
        users.add(inData);

        List<Group> groups = new ArrayList<>();
        groups.add(group);
        inData.setGroups(groups);

        //Userdetails userdetails = new Userdetails(inData.getIduser());
        //inData.setUserdetails(userdetails);

        User outData = userRepository.save(inData);

        logger.debug("##### New user's Login: "+outData.getLogin()+"  ID: "+outData.getIduser());
        return outData;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        User u = userRepository.findOne(id);
        return u;
    }

    public List<User> getUsersByName(String name) {
        List<Userdetails> udl = detailsRepository.findByName(name);
        List<User> result = new ArrayList<>();
        udl.forEach((userdetails) -> {
            result.add(userRepository.findOne(userdetails.getIddetails()));
        });
        return result;
    }

    public List<User> getUsersBySurname(String surname) {
        List<Userdetails> udl = detailsRepository.findBySurname(surname);
        List<User> result = new ArrayList<>();
        udl.forEach((userdetails) -> {
            result.add(userRepository.findOne(userdetails.getIddetails()));
        });
        return result;
    }

    public List<User> getUsersByNameAndSurname(String name, String surname) {
        List<Userdetails> udl = detailsRepository.findByNameAndSurname(name, surname);
        List<User> result = new ArrayList<>();
        udl.forEach((userdetails) -> {
            result.add(userRepository.findOne(userdetails.getIddetails()));
        });
        return result;
    }

    public void delUser(Long id) {
        User user = userRepository.findOne(id);
        if(user!=null){
            Userdetails userdetails = detailsRepository.findOne(id);
            //userdetails.setIddetails(Long.valueOf(1));
            //detailsRepository.save(userdetails);

            logger.debug("Deleting users "+user.getLogin() + " with id " + user.getIduser());
            userRepository.delete(id);
        }
    }

}
