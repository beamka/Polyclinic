package ua.clinic.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.clinic.jpa.Uaddress;
import ua.clinic.services.AddressMapper;
import ua.clinic.services.AddressService;
import ua.ibt.clinic.api.AddressAPI;
import ua.ibt.clinic.api.ListAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@RestController
public class AddressController {
    private static final Logger logger =  LoggerFactory.getLogger(AddressController.class);
    @Autowired
    AddressService addressService;
    @Autowired
    AddressMapper addressMapper;

    @RequestMapping(path = "/address/get/{id_user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListAddresses getAddress(@PathVariable Long id_user) {
        logger.debug(">>>>>>>>>> AddressController start getAddress >>>>>>>>>>");
        ListAddresses outData = new ListAddresses();
        try {
            List<Uaddress> uaddres = addressService.getAddress(id_user);
            List<AddressAPI> addres = new ArrayList<>();
            uaddres.forEach(uaddr-> {
                addres.add(addressMapper.toOutside(uaddr));
            });
            outData.addres = addres;
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error geting ListPhones. Expetion: "+e.getMessage(),e);
        }
        return outData;
    }

    @RequestMapping(path = "/address/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListAddresses addAddress(@RequestBody AddressAPI inData) {
        logger.debug(">>>>>>>>>> AddressController start addAddress >>>>>>>>>>");
        ListAddresses outData = new ListAddresses();
        try {
            Uaddress uphone = addressMapper.toInside(inData);
            List<Uaddress> uphones = addressService.addAddress(uphone,inData.iduser);
            List<AddressAPI> addres = new ArrayList<>();
            uphones.forEach(ua -> {
                addres.add(addressMapper.toOutside(ua));
            });
            outData.addres = addres;
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error addAddress. Expetion: "+e.getMessage(),e);
        }
        return outData;
    }

    @RequestMapping(path = "/address/del/{id_address},{id_user}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListAddresses delAddress(@PathVariable Long id_address, @PathVariable Long id_user) {
        logger.info(">>>>> AddressController start delAddress >>>>>");
        ListAddresses outData = new ListAddresses();
        try {
            addressService.delAddress(id_address);
            outData.retcode = 0;
            outData.sys_message = "AddressAPI was deleted successfully.";

            List<Uaddress> uaddres = addressService.getAddress(id_user);
            List<AddressAPI> addres = new ArrayList<>();
            uaddres.forEach(ua -> {
                addres.add(addressMapper.toOutside(ua));
            });
            outData.addres = addres;
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error delete AddressAPI. Expetion: " + e.getMessage(), e);
        }
        return outData;
    }
}
