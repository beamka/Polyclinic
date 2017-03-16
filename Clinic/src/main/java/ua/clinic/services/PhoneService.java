package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.clinic.jpa.Userdetails;
import ua.clinic.jpa.Uphone;
import ua.clinic.jpa.User;
import ua.clinic.repository.PhoneRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;
import ua.clinic.utils.IdGenerator;

import java.util.List;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@Service
public class PhoneService {
    private static final Logger logger = LoggerFactory.getLogger(PhoneService.class);

    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    UserdetailsRepository detailsRepository;
    @Autowired
    UserRepository userRepository;

    public List<Uphone> addPhone(Uphone inData, Long id_user) {
        User user = userRepository.findOne(id_user);
        Userdetails userdetails = detailsRepository.findOne(user.getIddetails());

        if(userdetails != null) {
            Long newId;
            do {
                newId = IdGenerator.newId();
            } while (phoneRepository.findOne(newId) != null);
            inData.setIdphone(newId);
            inData.setUserdetails(userdetails);
            phoneRepository.save(inData);
        }

        List<Uphone> uphones = phoneRepository.findByUserdetails(userdetails);
        logger.debug("##### List<Uphone>: " + uphones);
        return uphones;
    }

    public List<Uphone> getPhones(Long id_user) {
        User user = userRepository.findOne(id_user);
        Userdetails userdetails = detailsRepository.findOne(user.getIddetails());
        List<Uphone> uphones = userdetails.getPhone();
        return uphones;
    }

    public void delPhone(Long id) {
        logger.info("##### delPhone ID = " + id);
        Uphone uphone = phoneRepository.findOne(id);
        if (uphone != null) {
            logger.debug("##### Deleting PhoneAPI "+ uphone.getPhone()+" with id = "+ uphone.getIdphone());
            phoneRepository.delete(id);
        }
    }

    public Long getUserID(Long id_phone) {
        Uphone uphone = phoneRepository.findOne(id_phone);
        return uphone.getUserdetails().getIduser();
    }

}
