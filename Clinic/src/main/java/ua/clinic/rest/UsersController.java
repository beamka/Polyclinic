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

import ua.clinic.jpa.Ugroup;
import ua.clinic.jpa.User;
import ua.clinic.services.UserMapper;
import ua.clinic.services.UserService;
import ua.ibt.clinic.api.AddUserRequest;
import ua.ibt.clinic.api.GenericReply;
import ua.ibt.clinic.api.UserListReply;

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

	@RequestMapping(path = "/users/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserListReply getAllUsers() {
		UserListReply reply = new UserListReply();
		for (User au : userService.getAllUsers()) {
			reply.users.add(userMapper.fromInternal(au));
			logger.info("EEEEEE");
		}
		return reply;
	}

	@RequestMapping(path = "/users/byid/{userid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserListReply getUserById(@PathVariable Long userid) {
		UserListReply reply = new UserListReply();
		reply.users.add(userMapper.fromInternal(userService.getUserById(userid)));
		return reply;
	}

	@RequestMapping(path = "/users/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserListReply addUser(@RequestBody AddUserRequest req) {
		UserListReply rep = new UserListReply();
		try {
			User au;
			au = userService.addUser(userMapper.toInternal(req.user));
			rep.users.add(userMapper.fromInternal(au));

			userService.addUser(userMapper.toInternal(req.user));
		} catch (Exception e) {
			rep.retcode = -1;
			rep.error_message = e.getMessage();
			logger.error("Error adding user. Expetion: "+e.getMessage(),e);
		}
		return rep;
	}

	@RequestMapping(path="/users/del/{id_user}",  method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public GenericReply delUser(@PathVariable Long id_user ){
		logger.info("del-1>>>");
		GenericReply rep = new GenericReply();
		try{
			logger.info("del-2>>>");
			userService.delUser(id_user);
		}catch(Exception e){
			rep.retcode = -1;
			rep.error_message = e.getMessage();
			logger.error("Error adding user. Expetion: "+e.getMessage(),e);
			logger.info("del-3>>> "+e.getMessage(),e);
		}
		return rep;
	}

	@RequestMapping(path = "/users/uu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void uuu() {
		logger.info("UUUUUUU>>>");
	}
}

