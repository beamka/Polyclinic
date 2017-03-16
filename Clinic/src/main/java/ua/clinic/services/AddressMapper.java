package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.clinic.jpa.Uaddress;
import ua.clinic.repository.AddressRepository;
import ua.ibt.clinic.api.AddressAPI;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@Component
public class AddressMapper {
    private static final Logger logger =  LoggerFactory.getLogger(AddressMapper.class);

    @Autowired
    AddressRepository addressRepository;

    public Uaddress toInside(AddressAPI inData) {
        Uaddress uaddress = null;
        if(inData != null){
            uaddress = new Uaddress();
            //addres.setIdaddress(inData.idaddress);
            uaddress.setCountry(inData.country);
            uaddress.setCity(inData.city);
            uaddress.setStreet(inData.street);
            uaddress.setNumhouse(inData.numhouse);
            uaddress.setHull(inData.hull);
            uaddress.setFlat(inData.flat);
            logger.debug("##### toInside: result addres = "+ uaddress);
        }
        return uaddress;
    }

    public AddressAPI toOutside(Uaddress inData) {
        AddressAPI addressAPI = null;
        if (inData != null) {
            addressAPI = new AddressAPI();
            addressAPI.idaddress = inData.getIdaddress();
            addressAPI.country = inData.getCountry();
            addressAPI.city = inData.getCity();
            addressAPI.street = inData.getStreet();
            addressAPI.numhouse = inData.getNumhouse();
            addressAPI.hull = inData.getHull();
            addressAPI.flat = inData.getFlat();
        }
        return addressAPI;
    }
}
