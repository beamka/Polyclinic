/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Ugroup;
import ua.clinic.jpa.User;

import java.util.List;

/**
 * @author Iryna Tkachova
 *
 */
public interface UgroupRepository extends CrudRepository<Ugroup, Long> {

    @Override
    List<Ugroup> findAll();

    Ugroup findByGroupname(String groupname);

    List<User> findUsersByGroupname(String groupname);

}
