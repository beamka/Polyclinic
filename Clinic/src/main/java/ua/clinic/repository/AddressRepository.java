/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Address;

/**
 * @author Iryna Tkachova
 *
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

}
