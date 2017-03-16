/**
 * 
 */
package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.clinic.jpa.Group;
import ua.clinic.jpa.User;
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;
import ua.ibt.clinic.api.GroupAPI;
import ua.ibt.clinic.api.UserAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Iryna Tkachova
 *
 */
@Component
public class UserMapper {
	private static final Logger logger =  LoggerFactory.getLogger(UserMapper.class);

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserdetailsRepository detailsRepository;
	@Autowired
	UgroupRepository groupRepository;
	@Autowired
	UgroupMapper ugroupMapper;

	public User toInside(UserAPI inData) {
		User user = null;
		if(inData != null){
			user = new User();
			//newUser.setIduser(Long.valueOf(1));
			user.setIduser(inData.id_user);
			user.setIddetails(inData.id_details);
			user.setLogin(inData.login);
			user.setPasswdhash(inData.passwdhash);
			user.setEmail(inData.email);
			user.setCreatedby(inData.createdby);
			user.setLastlogin(inData.lastlogin);

			List<Group> groups = new ArrayList<>();
			inData.groupAPIS.forEach(group -> {
				groups.add(ugroupMapper.toInside(group));
			});
			user.setGroups(groups);
			logger.debug("##### toInside: result User = "+ user);
		}
		return user;
	}

	public UserAPI toOutside(User inData) {
		UserAPI userAPI = null;
		if (inData != null) {
			userAPI = new UserAPI();
			userAPI.id_user = inData.getIduser();
			userAPI.id_details = inData.getIddetails();
			userAPI.login = inData.getLogin();
			userAPI.passwdhash = inData.getPasswdhash();
			userAPI.email = inData.getEmail();
			userAPI.createdby = inData.getCreatedby();
			userAPI.lastlogin = inData.getLastlogin();

			List<GroupAPI> groupAPIS = new ArrayList<>();
			inData.getGroups().forEach(ugroup -> {
				groupAPIS.add(ugroupMapper.toOutside(ugroup));
			});
			userAPI.groupAPIS = groupAPIS;
		}
		return userAPI;
	}
}
