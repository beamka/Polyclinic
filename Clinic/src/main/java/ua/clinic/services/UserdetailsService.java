package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.clinic.jpa.Userdetails;
import ua.clinic.jpa.Doctor;
import ua.clinic.jpa.User;
import ua.clinic.repository.DoctorRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;

/**
 * Created by Iryna Tkachova on 11.03.2017.
 */
@Service
public class UserdetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserdetailsService.class);

    @Autowired
    UserdetailsRepository detailsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;


    public Userdetails addDetails(Userdetails inData) {
        User user = userRepository.findOne(inData.getIduser());
        Userdetails userdetails;
        if (user.getIddetails() != null) {
            userdetails = detailsRepository.findOne(user.getIddetails());
            logger.debug("##### Userdetails is old: " + userdetails);
        } else {
            userdetails = new Userdetails(user.getIduser());
            user.setIddetails(user.getIduser());
            userRepository.save(user);
            logger.debug("##### Userdetails is new: " + userdetails);
        }
        userdetails.setIduser(user.getIduser());
        userdetails.setName(inData.getName());
        userdetails.setSurname(inData.getSurname());
        userdetails.setMiddlename(inData.getMiddlename());
        userdetails.setBirthday(inData.getBirthday());
        userdetails.setSex(inData.getSex());
        userdetails.setNumcard(inData.getNumcard());
        userdetails.setNotes(inData.getNotes());
        Userdetails outData = detailsRepository.save(userdetails);
        logger.debug("##### Userdetails revrited: Userdetails: " + outData);
        return outData;
    }

    public Userdetails getDetails(Long id_user) {
        User user = userRepository.findOne(id_user);
        Userdetails outData = null;
        if (user.getIddetails() != null) {
            outData = detailsRepository.findOne(user.getIddetails());
        }
        logger.debug("##### getUserdetails: " + outData);
        return outData;
    }

    public void delDetails(Long id_details) {
        Userdetails userdetails = detailsRepository.findOne(id_details);
        if(userdetails != null){
            logger.debug("##### Deleting userdetails "+ userdetails.getNumcard() + " with id " + userdetails.getIddetails());
            detailsRepository.delete(id_details);
        }
    }
}
