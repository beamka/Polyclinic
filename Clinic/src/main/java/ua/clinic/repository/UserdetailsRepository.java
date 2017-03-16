/**
 * 
 */
package ua.clinic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Userdetails;

/**
 * @author Iryna Tkachova
 *
 */
public interface UserdetailsRepository extends CrudRepository<Userdetails, Long> {

	List<Userdetails> findByNameAndSurname(String Name, String Surname);

	List<Userdetails> findByName(String Name);

	List<Userdetails> findBySurname(String Surname);
}
