/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Phone;

/**
 * @author Iryna Tkachova
 *
 */
public interface PhoneRepository extends CrudRepository<Phone, Long> {

}
