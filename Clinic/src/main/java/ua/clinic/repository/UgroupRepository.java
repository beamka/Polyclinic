/**
 * 
 */
package ua.clinic.repository;

import org.springframework.data.repository.CrudRepository;

import ua.clinic.jpa.Group;

import java.util.List;

/**
 * @author Iryna Tkachova
 *
 */
public interface UgroupRepository extends CrudRepository<Group, Long> {

    @Override
    List<Group> findAll();

    Group findByGroupname(String groupname);


}
