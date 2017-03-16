package ua.clinic.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.clinic.jpa.Userdetails;
import ua.clinic.services.UserdetailsMapper;
import ua.clinic.services.UserdetailsService;
import ua.ibt.clinic.api.DetailsAPI;
import ua.ibt.clinic.api.DoctorAPI;

/**
 * Created by Iryna Tkachova on 11.03.2017.
 */
@RestController
public class UserdetailsController {
    private static final Logger logger =  LoggerFactory.getLogger(UserdetailsController.class);

    @Autowired
    UserdetailsService userdetailsService;
    @Autowired
    UserdetailsMapper userdetailsMapper;

    @RequestMapping(path = "/details/set", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DetailsAPI setDetails(@RequestBody DetailsAPI inData) {
        logger.debug(">>>>>>>>>> UserdetailsController start setUserdetails >>>>>>>>>>");
        DetailsAPI outData = new DetailsAPI();
        try {
            Userdetails userdetails = userdetailsService.addDetails(userdetailsMapper.toInside(inData));
            outData = userdetailsMapper.toOutside(userdetails);
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error seting userdetails. Expetion: "+e.getMessage(),e);
        }
        return outData;
    }

    @RequestMapping(path = "/details/get/{id_user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DetailsAPI getDetails(@PathVariable Long id_user) {
        logger.debug(">>>>>>>>>> UserdetailsController start getUserdetails >>>>>>>>>>");
        DetailsAPI outData = new DetailsAPI();
        try {
        outData = userdetailsMapper.toOutside(userdetailsService.getDetails(id_user));
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error geting userdetails. Expetion: "+e.getMessage(),e);
        }
        return outData;
    }

}
