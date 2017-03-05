/**
 *
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 */
@Entity
@Table(name = "ugroup")
//@NamedQueries({@NamedQuery(name = "Ugroup.findAll", query = "SELECT u FROM ugroup u")})
public class Ugroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_group")
    private Long idgroup;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "group_name")
    private String groupname;

    @Size(max = 200)
    @Column(name = "description")
    private String description;

//    @JoinTable(name = "ugroup", joinColumns = {
//            @JoinColumn(name = "id_group", referencedColumnName = "id_group") }, inverseJoinColumns = {
//            @JoinColumn(name = "id_user", referencedColumnName = "id_user") })
    @ManyToMany
    private List<User> users;

    public Ugroup() {

    }

    public Ugroup(Long idgroup) {
        this.idgroup = idgroup;
    }

    public Ugroup(Long idgroup, String groupname, String description) {
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
        if (!(object instanceof Ugroup)) {
            return false;
        }
        Ugroup other = (Ugroup) object;
        return !((this.idgroup == null && other.idgroup != null)
                || (this.idgroup != null && !this.idgroup.equals(other.idgroup)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.Ugroup[ idgroup=" + idgroup + " ]";
    }

}
