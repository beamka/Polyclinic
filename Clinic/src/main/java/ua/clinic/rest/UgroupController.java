package ua.clinic.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.clinic.jpa.Ugroup;
import ua.clinic.jpa.User;
import ua.clinic.services.UgroupMapper;
import ua.clinic.services.UgroupService;
import ua.clinic.services.UserMapper;
import ua.ibt.clinic.api.*;

import java.util.List;

/**
 * Created by Iryna Tkachova on 08.03.2017.
 */
@RestController
public class UgroupController {
    private static final Logger logger = LoggerFactory.getLogger(UgroupController.class);

    @Autowired
    UgroupService ugroupService;
    @Autowired
    UgroupMapper ugroupMapper;
    @Autowired
    UserMapper userMapper;

    @RequestMapping(path = "/group/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListGroupReceive newGroup(@RequestBody Group inData) {
        logger.debug(">>>>>>>>>> UgroupController start newGroup >>>>>>>>>>");
        ListGroupReceive outData = new ListGroupReceive();
        try {
            Ugroup user = ugroupService.newGroup(ugroupMapper.toInside(inData));
            outData.groups.add(ugroupMapper.toOutside(user));
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error adding group. Expetion: " + e.getMessage(), e);
        }
        return outData;
    }

    @RequestMapping(path = "/group/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListGroupReceive getAllGroups() {
        logger.debug(">>>>>>>>>> UgroupController start getAllGroups >>>>>>>>>>");
        ListGroupReceive outData = new ListGroupReceive();
        for (Ugroup ugroup : ugroupService.getAllUgroup()) {
            outData.groups.add(ugroupMapper.toOutside(ugroup));
        }
        return outData;
    }

    @RequestMapping(path = "/group/defoult", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListGroupReceive setDefoultGroups() {
        logger.debug(">>>>>>>>>> UgroupController start setDefoultGroups >>>>>>>>>>");
        ListGroupReceive outData = new ListGroupReceive();
        try {
            ugroupService.createDefoultGroups();
            for (Ugroup ugroup : ugroupService.getAllUgroup()) {
                outData.groups.add(ugroupMapper.toOutside(ugroup));
            }
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error adding group. Expetion: " + e.getMessage(), e);
        }
        return outData;
    }

    @RequestMapping(path = "/user/del/{id_group}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SysMessage delGroup(@PathVariable Long id_group) {
        logger.info(">>>>> UgroupController start delGroup >>>>>");
        SysMessage outData = new SysMessage();
        try {
            ugroupService.delUgroup(id_group);
            outData.retcode = 0;
            outData.sys_message = "Group was deleted successfully.";
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error delete group. Expetion: " + e.getMessage(), e);
        }
        return outData;
    }

    @RequestMapping(path = "/group/delAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SysMessage delAllGroups() {
        logger.info(">>>>>  UgroupController start delAllGroups >>>>>");
        SysMessage outData = new SysMessage();
        try {
            for (Ugroup ugroup : ugroupService.getAllUgroup()) {
                ugroupService.delUgroup(ugroup.getIdgroup());
            }
            outData.retcode = 0;
            outData.sys_message = "All groups was deleted successfully.";
        } catch (Exception e) {
            outData.retcode = -1;
            outData.sys_message = e.getMessage();
            logger.error("Error delete all groups. Expetion: " + e.getMessage(), e);
        }
        return outData;
    }

    @RequestMapping(path = "/group/byid/{id_group}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListGroupReceive getGroupById(@PathVariable Long id_group) {
        logger.info(">>>>>  UgroupController start getGroupById >>>>>");
        ListGroupReceive outData = new ListGroupReceive();
        outData.groups.add(ugroupMapper.toOutside(ugroupService.getGroupById(id_group)));
        return outData;
    }

    @RequestMapping(path = "/group/usersbyname/{groupname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ListUsersReceive getUsersByGroupname(@PathVariable String groupname) {
        logger.info(">>>>>  UgroupController start getUsersByGroupname >>>>>");
        ListUsersReceive outData = new ListUsersReceive();
        List<User> users = ugroupService.getUsersByGroupname(groupname);
        for(User user : users){
            outData.users.add(userMapper.toOutside(user));
        }
        return outData;
    }

}
