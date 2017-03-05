/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Visit;

/**
 * @author Iryna Tkachova
 *
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {

}
