/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Specialty;

/**
 * @author Iryna Tkachova
 *
 */
public interface SpecialtyCodeRepository extends CrudRepository<Specialty, Long> {

}
