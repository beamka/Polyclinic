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
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;
import ua.clinic.utils.EntityIdGenerator;
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
            newId = EntityIdGenerator.random();
        } while(userRepository.findOne(newId) != null);
        inData.setIduser(newId);
        Ugroup ugroup = ugroupRepository.findByGroupname("guest");
        List<Ugroup> ugroups = new ArrayList<>();
        ugroups.add(ugroup);
        inData.setUgroups(ugroups);
        inData.getUserdetails().setIddetails(newId);
        User outData = userRepository.save(inData);
        logger.debug("##### New user's Login: "+outData.getLogin()+"  ID: "+outData.getIduser());

        List<User> users = ugroup.getUsers();
        users.add(outData);
        ugroup.setUsers(users);
        ugroupRepository.save(ugroup);

        return outData;
    }

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
           // List<Ugroup> gl = u.getUgroups();
            detailsRepository.delete(id);
            userRepository.delete(id);
        }
    }

}
