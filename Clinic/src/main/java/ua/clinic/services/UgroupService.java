package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.clinic.jpa.Group;
import ua.clinic.jpa.User;
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.utils.EntityIdGenerator;

import java.util.List;

/**
 * Created by Iryna Tkachova on 08.03.2017.
 */
@Service
public class UgroupService {
    private static final Logger logger = LoggerFactory.getLogger(UgroupService.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    UgroupRepository ugroupRepository;

    public Group newGroup(Group inData) {
        Long newId;
        do {
            newId = EntityIdGenerator.random();
        } while (ugroupRepository.findOne(newId) != null);
        inData.setIdgroup(newId);
        Group outData = ugroupRepository.save(inData);
        logger.debug("##### New group's groupname: " + outData.getGroupname() + "  ID: " + outData.getIdgroup());
        return outData;
    }

    public void createDefoultGroups() {
        logger.debug(">>>>> createDefoultGroups >>>>>");

        Group guest = new Group(Long.valueOf(1), "guest", "New registered user");
        ugroupRepository.save(guest);
        Group patient = new Group(Long.valueOf(2), "patient", "patient");
        ugroupRepository.save(patient);
        Group doctor = new Group(Long.valueOf(3), "doctor", "doctor");
        ugroupRepository.save(doctor);
        Group admin = new Group(Long.valueOf(4), "admin", "admin");
        ugroupRepository.save(admin);
    }

    public List<Group> getAllUgroup() {

        return ugroupRepository.findAll();
    }

    public Group getGroupById(Long id) {
        Group group = ugroupRepository.findOne(id);
        return group;
    }

    public List<User> getUserByGroupname(String group_name) {
        Group group = ugroupRepository.findByGroupname(group_name);
        List<User> users = group.getUsers();
        return users;
    }

    public void delUgroup(Long id) {
        logger.info("##### delUgroup ID = " + id);
        Group group = ugroupRepository.findOne(id);
        if (group != null) {
            logger.debug("Deleting users %s with id %s", group.getGroupname(), group.getIdgroup());
            ugroupRepository.delete(id);
        }
    }
}
