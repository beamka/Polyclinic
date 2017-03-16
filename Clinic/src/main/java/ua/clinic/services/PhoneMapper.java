package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.clinic.jpa.Uphone;
import ua.clinic.repository.PhoneRepository;
import ua.ibt.clinic.api.PhoneAPI;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@Component
public class PhoneMapper {
    private static final Logger logger =  LoggerFactory.getLogger(PhoneMapper.class);

    @Autowired
    PhoneRepository phoneRepository;

    public Uphone toInside(PhoneAPI inData) {
        Uphone uphone = null;
        if(inData != null){
            uphone = new Uphone();
            //phoneAPI.setIdphone(inData.idphone);
            uphone.setPhone(inData.phone);
            uphone.setPhoneinfo(inData.phoneinfo);
            logger.debug("##### toInside: result PhoneAPI = "+ uphone);
        }
        return uphone;
    }

    public PhoneAPI toOutside(Uphone inData) {
        PhoneAPI phoneAPI = null;
        if (inData != null) {
            phoneAPI = new PhoneAPI();
            phoneAPI.idphone = inData.getIdphone();
            phoneAPI.phone = inData.getPhone();
            phoneAPI.phoneinfo = inData.getPhoneinfo();
        }
        return phoneAPI;
    }
}
