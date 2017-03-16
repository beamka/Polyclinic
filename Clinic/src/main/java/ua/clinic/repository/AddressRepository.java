/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Userdetails;
import ua.clinic.jpa.Uaddress;

import java.util.List;

/**
 * @author Iryna Tkachova
 *
 */
public interface AddressRepository extends CrudRepository<Uaddress, Long> {

    List<Uaddress> findByUserdetails(Userdetails udetails);

}
