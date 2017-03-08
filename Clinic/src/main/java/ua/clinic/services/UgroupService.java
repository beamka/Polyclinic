package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.clinic.jpa.Ugroup;
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

    public Ugroup newGroup(Ugroup inData) {
        Long newId;
        do {
            newId = EntityIdGenerator.random();
        } while (ugroupRepository.findOne(newId) != null);
        inData.setIdgroup(newId);
        Ugroup outData = ugroupRepository.save(inData);
        logger.debug("##### New group's groupname: " + outData.getGroupname() + "  ID: " + outData.getIdgroup());
        return outData;
    }

    public void createDefoultGroups() {
        logger.debug(">>>>> createDefoultGroups >>>>>");

        Ugroup guest = new Ugroup(Long.valueOf(1), "guest", "New registered user");
        ugroupRepository.save(guest);
        Ugroup patient = new Ugroup(Long.valueOf(2), "patient", "patient");
        ugroupRepository.save(patient);
        Ugroup doctor = new Ugroup(Long.valueOf(3), "doctor", "doctor");
        ugroupRepository.save(doctor);
        Ugroup admin = new Ugroup(Long.valueOf(4), "admin", "admin");
        ugroupRepository.save(admin);
    }

    public List<Ugroup> getAllUgroup() {

        return ugroupRepository.findAll();
    }

    public Ugroup getGroupById(Long id) {
        Ugroup ugroup = ugroupRepository.findOne(id);
        return ugroup;
    }

    public List<User> getUsersByGroupname(String group_name) {
        System.out.println("group_name>>>>"+group_name);
        List<User> users = ugroupRepository.findUsersByGroupname(group_name);
        System.out.println("users>>>>"+users);
        return users;
    }

    public void delUgroup(Long id) {
        logger.info("##### delUgroup ID = " + id);
        Ugroup ugroup = ugroupRepository.findOne(id);
        if (ugroup != null) {
            logger.debug("Deleting users %s with id %s", ugroup.getGroupname(), ugroup.getIdgroup());
            ugroupRepository.delete(id);
        }
    }
}
