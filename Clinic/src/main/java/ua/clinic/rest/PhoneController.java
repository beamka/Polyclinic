package ua.clinic.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.clinic.jpa.Uphone;
import ua.clinic.services.PhoneMapper;
import ua.clinic.services.PhoneService;
import ua.ibt.clinic.api.ListPhones;
import ua.ibt.clinic.api.PhoneAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@RestController
public class PhoneController {
    private static final Logger logger =  LoggerFactory.getLogger(PhoneController.class);

    @Autowired
    PhoneService phoneService;
    @Autowired
    PhoneMapper phoneMapper;

    @RequestMapping(path = "/phone/get/{id_user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListPhones getPhones(@PathVariable Long id_user) {
        logger.debug(">>>>>>>>>> PhoneController start getUphones >>>>>>>>>>");
        ListPhones outData = new ListPhones();
        try {
            List<Uphone> uphones = phoneService.getPhones(id_user);
            List<PhoneAPI> phoneAPI = new ArrayList<>();
            uphones.forEach(uphone -> {
                phoneAPI.add(phoneMapper.toOutside(uphone));
            });
            outData.phoneAPI = phoneAPI;
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error geting ListPhones. Expetion: "+e.getMessage(),e);
        }
        return outData;
    }

    @RequestMapping(path = "/phone/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListPhones addPhone(@RequestBody PhoneAPI inData) {
        logger.debug(">>>>>>>>>> PhoneController start addPhone >>>>>>>>>>");
        ListPhones outData = new ListPhones();
        try {
            Uphone uphone = phoneMapper.toInside(inData);
            List<Uphone> uphones = phoneService.addPhone(uphone,inData.iduser);
            List<PhoneAPI> phoneAPI = new ArrayList<>();
            uphones.forEach(up -> {
                phoneAPI.add(phoneMapper.toOutside(up));
            });
            outData.phoneAPI = phoneAPI;
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error addPhone. Expetion: "+e.getMessage(),e);
        }
        return outData;
    }

    @RequestMapping(path = "/phone/del/{id_phone},{id_user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListPhones delPhone(@PathVariable Long id_phone, @PathVariable Long id_user) {
        logger.info(">>>>> PhoneController start delPhone >>>>>");
        ListPhones outData = new ListPhones();
        try {
            phoneService.delPhone(id_phone);
            outData.retcode = 0;
            outData.sys_message = "PhoneAPI was deleted successfully.";

            List<Uphone> uphones = phoneService.getPhones(id_user);
            List<PhoneAPI> phoneAPI = new ArrayList<>();
            uphones.forEach(uphone -> {
                phoneAPI.add(phoneMapper.toOutside(uphone));
            });
            outData.phoneAPI = phoneAPI;
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error delete PhoneAPI. Expetion: " + e.getMessage(), e);
        }
        return outData;
    }
}
