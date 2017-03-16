package ua.clinic.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.clinic.jpa.User;
import ua.clinic.services.UserMapper;
import ua.clinic.services.UserService;
import ua.ibt.clinic.api.*;

/**
 * @author Iryna Tkachova
 *
 */
@RestController
public class UsersController {
	private static final Logger logger =  LoggerFactory.getLogger(UsersController.class);

	@Autowired
	UserService userService;
	@Autowired
	UserMapper userMapper;

	@RequestMapping(path = "/user/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ListUsersReceive newUser(@RequestBody UserAPI inData) {
		logger.debug(">>>>>>>>>> UsersController start newUser >>>>>>>>>>");
		ListUsersReceive outData = new ListUsersReceive();
		try {
			User user = userService.newUser(userMapper.toInside(inData));
			outData.users.add(userMapper.toOutside(user));
		} catch (Exception e) {
			outData.retcode = -1;
			outData.sys_message = e.getMessage();
			logger.error("Error adding new user. Expetion: "+e.getMessage(),e);
		}
		return outData;
	}

	@RequestMapping(path = "/user/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ListUsersReceive getAllUsers() {
		logger.debug(">>>>>>>>>> UsersController start getAllUsers >>>>>>>>>>");
		ListUsersReceive reply = new ListUsersReceive();
		userService.getAllUsers().forEach(user -> reply.users.add(userMapper.toOutside(user)));
		return reply;
	}

	@RequestMapping(path = "/user/byid/{userid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ListUsersReceive getUserById(@PathVariable Long userid) {
		logger.debug(">>>>>>>>>> UsersController start getUserById >>>>>>>>>>");
		ListUsersReceive reply = new ListUsersReceive();
		reply.users.add(userMapper.toOutside(userService.getUserById(userid)));
		return reply;
	}

	@RequestMapping(path="/user/del/{id_user}",  method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SysMessage delUser(@PathVariable Long id_user ){
		logger.debug(">>>>>>>>>> UsersController start delUser >>>>>>>>>>");
		SysMessage rep = new SysMessage();
		try{
			System.out.println("del1>>>>>>>>>>>>>>>>");
			userService.delUser(id_user);
		}catch(Exception e){
			rep.retcode = -1;
			rep.sys_message = e.getMessage();
			logger.error("Error adding user. Expetion: "+e.getMessage(),e);
			logger.info("del-3>>> "+e.getMessage(),e);
		}
		return rep;
	}

}

