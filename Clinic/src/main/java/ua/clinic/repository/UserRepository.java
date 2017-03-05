/**
 * 
 */
package ua.clinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.User;

/**
 * @author Iryna Tkachova
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {

	@Override
	List<User> findAll();

	String findPasswdhashByLogin(String Login);
}
