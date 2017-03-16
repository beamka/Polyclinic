package ua.clinic.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.clinic.jpa.Userdetails;
import ua.clinic.services.DoctorService;
import ua.clinic.services.UserdetailsMapper;
import ua.clinic.services.UserdetailsService;
import ua.ibt.clinic.api.DetailsAPI;
import ua.ibt.clinic.api.DoctorAPI;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@RestController
public class DoctorController {
    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    DoctorService doctorService;
    @Autowired
    UserdetailsMapper userdetailsMapper;

    @RequestMapping(path = "/doctor/set", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DetailsAPI setDoctor(@RequestBody DoctorAPI inData) {
        logger.debug(">>>>>>>>>> DoctorController start setDoctor >>>>>>>>>>");
        DetailsAPI outData = new DetailsAPI();
        try {
            Userdetails userdetails = doctorService.setDoctor(inData.iduser, inData.tabnumber);
            outData = userdetailsMapper.toOutside(userdetails);
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error seting Doctor. Expetion: "+e.getMessage(),e);
        }
        return outData;
    }


}
