package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.clinic.jpa.Userdetails;
import ua.clinic.repository.UserdetailsRepository;
import ua.ibt.clinic.api.DetailsAPI;

/**
 * Created by Iryna Tkachova on 11.03.2017.
 */
@Component
public class UserdetailsMapper {
    private static final Logger logger =  LoggerFactory.getLogger(UserdetailsMapper.class);

    @Autowired
    UserdetailsRepository userdetailsRepository;

    public Userdetails toInside(DetailsAPI inData) {
        Userdetails newUserdetails = null;
        if(inData != null){
            newUserdetails = new Userdetails();
            newUserdetails.setIduser(inData.iduser);
            //newUserdetails.setIddetails(Long.valueOf(1));
            newUserdetails.setNumcard(inData.numcard);
            newUserdetails.setName(inData.name);
            newUserdetails.setSurname(inData.surname);
            newUserdetails.setMiddlename(inData.middlename);
            newUserdetails.setBirthday(inData.birthday);
            newUserdetails.setSex(inData.sex);
            newUserdetails.setNotes(inData.notes);
            logger.debug("##### newUserdetails: "+ newUserdetails);
        }
        return newUserdetails;
    }

    public DetailsAPI toOutside(Userdetails inData) {
        DetailsAPI detailsAPI = null;
        if (inData != null) {
            detailsAPI = new DetailsAPI();
            detailsAPI.numcard = inData.getNumcard();
            detailsAPI.name = inData.getName();
            detailsAPI.surname = inData.getSurname();
            detailsAPI.middlename = inData.getMiddlename();
            detailsAPI.birthday = inData.getBirthday();
            detailsAPI.sex = inData.getSex();
            detailsAPI.notes = inData.getNotes();
            if(inData.getDoctor() != null){
                detailsAPI.id_doctor = inData.getDoctor().getIddoctor();
            }
        }
        return detailsAPI;
    }
}
