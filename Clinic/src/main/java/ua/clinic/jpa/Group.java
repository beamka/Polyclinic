/**
 *
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 */
@Entity
@Table(name = "ugroup")
//@NamedQueries({@NamedQuery(name = "Group.findAll", query = "SELECT u FROM ugroup u")})
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_group")
    private Long idgroup;

    @Size(min = 1, max = 20)
    @Column(name = "group_name")
    private String groupname;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

//    @ManyToMany
//    @JoinTable(name = "ugroup_user", joinColumns =
//            {@JoinColumn(name = "id_group", referencedColumnName = "id_group")},
//            inverseJoinColumns =
//                    {@JoinColumn(name = "id_user", referencedColumnName = "id_user") })
    @ManyToMany
    @JoinTable(name = "ugroup_user", joinColumns =
    @JoinColumn(name = "id_group"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    public Group() {

    }

    public Group(Long idgroup) {
        this.idgroup = idgroup;
    }

    public Group(Long idgroup, String groupname, String description) {
        this.idgroup = idgroup;
        this.groupname = groupname;
        this.description = description;
    }

    public Long getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(Long idgroup) {
        this.idgroup = idgroup;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgroup != null ? idgroup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Group)) {
            return false;
        }
        Group other = (Group) object;
        return !((this.idgroup == null && other.idgroup != null)
                || (this.idgroup != null && !this.idgroup.equals(other.idgroup)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.Group[ idgroup=" + idgroup + " ]";
    }

}
