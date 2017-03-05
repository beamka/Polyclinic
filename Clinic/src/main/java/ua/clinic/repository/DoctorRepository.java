/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Doctor;

/**
 * @author Iryna Tkachova
 *
 */
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
