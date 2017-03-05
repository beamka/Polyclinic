/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.SpecialtyCode;

/**
 * @author Iryna Tkachova
 *
 */
public interface SpecialtyCodeRepository extends CrudRepository<SpecialtyCode, Long> {

}
