/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Userdetails;
import ua.clinic.jpa.Uphone;

import java.util.List;

/**
 * @author Iryna Tkachova
 *
 */
public interface PhoneRepository extends CrudRepository<Uphone, Long> {

    List<Uphone> findByUserdetails(Userdetails udetails);

}
