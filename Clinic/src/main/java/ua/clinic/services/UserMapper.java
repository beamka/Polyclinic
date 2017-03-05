/**
 * 
 */
package ua.clinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.clinic.jpa.User;
import ua.clinic.jpa.Userdetails;
import ua.clinic.repository.UgroupRepository;
import ua.clinic.repository.UserRepository;
import ua.clinic.repository.UserdetailsRepository;
import ua.clinic.utils.EntityIdGenerator;
import ua.ibt.clinic.api.ClinicUser;

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

	public ClinicUser fromInternal(User u) {
		ClinicUser lu = null;
		if (u != null) {
			lu = new ClinicUser();
			Userdetails ud = u.getUserdetails();
			//lu.isLibrarian = u.getIduser() < 100;
			lu.login = u.getLogin();
			lu.user_id = u.getIduser();
			if (ud != null) {
				lu.firstName = u.getUserdetails().getName();
				lu.lastName = u.getUserdetails().getSurname();
			}
		}
		return lu;
	}

	public User toInternal(ClinicUser lu) {
		User au = null;
		return au;
	}

	private User newUser() {
		//TODO: get logged user from security context
		String createdBy = "REST";
		User au = new User();
		Userdetails ud = new Userdetails();
		boolean idOK = false;
		Long id = 0L;
		while (!idOK) {
			id = EntityIdGenerator.random();
			idOK = !userRepository.exists(id);
		}
		//notNull
		ud.setNotes("none");
		au.setPasswdhash("*");
		au.setCreatedby(createdBy);
		au.setIduser(id);
		ud.setIddetails(id);
		au.setUserdetails(ud);
		return au;
	}
}
