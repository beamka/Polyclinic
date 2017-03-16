package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.clinic.jpa.Uaddress;
import ua.clinic.jpa.User;
import ua.clinic.jpa.Userdetails;
import ua.clinic.repository.AddressRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;
import ua.clinic.utils.IdGenerator;

import java.util.List;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@Service
public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserdetailsRepository detailsRepository;
    @Autowired
    UserRepository userRepository;

    public List<Uaddress> addAddress(Uaddress inData, Long id_user) {
        User user = userRepository.findOne(id_user);
        Userdetails userdetails = detailsRepository.findOne(user.getIddetails());

        if(userdetails != null) {
            Long newId;
            do {
                newId = IdGenerator.newId();
            } while (addressRepository.findOne(newId) != null);
            inData.setIdaddress(newId);
            inData.setUserdetails(userdetails);
            addressRepository.save(inData);
        }
        List<Uaddress> addres = addressRepository.findByUserdetails(userdetails);

        logger.debug("##### List<Uaddress>: " + addres);
        return addres;
    }

    public List<Uaddress> getAddress(Long id_user) {
        User user = userRepository.findOne(id_user);
        Userdetails userdetails = detailsRepository.findOne(user.getIddetails());
        List<Uaddress> addres = userdetails.getAddres();
        return addres;
    }

    public void delAddress(Long id) {
        logger.info("##### delPhone ID = " + id);
        Uaddress uaddress = addressRepository.findOne(id);
        if (uaddress != null) {
            logger.debug("##### Deleting PhoneAPI "+ uaddress.getStreet()+" with id = "+ uaddress.getIdaddress());
            addressRepository.delete(id);
        }
    }

    public Long getUserID(Long id_address) {
        Uaddress uaddress = addressRepository.findOne(id_address);
        return uaddress.getUserdetails().getIduser();
    }

}
