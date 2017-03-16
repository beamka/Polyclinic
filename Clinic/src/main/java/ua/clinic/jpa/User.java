/**
 * 
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 *
 */
@Entity
@Table(name = "user")
//@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM user u") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "id_user")
	private Long iduser;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "login")
	private String login;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "passwdhash")
	private String passwdhash;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "email")
	private String email;

	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 20)
	@Column(name = "createdby")
	private String createdby;

	@Column(name = "lastlogin")
	@Temporal(TemporalType.DATE)
	private Date lastlogin;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "ugroup_user", joinColumns =
	@JoinColumn(name = "id_user"),
			inverseJoinColumns = @JoinColumn(name = "id_group"))
	private List<Group> groups;

	@Column(name = "id_details")
	private Long iddetails;

	public User() {

	}

	public User(Long iduser) {
		this.iduser = iduser;
	}

	public User(Long iduser, String login, String passwdhash, String email, String createdBy, Long iddetails) {
		super();
		this.iduser = iduser;
		this.login = login;
		this.passwdhash = passwdhash;
		this.email = email;
		this.createdby = createdBy;
		//this.userdetails = userdetails;
		this.iddetails = iddetails;
	}

	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswdhash() {
		return passwdhash;
	}

	public void setPasswdhash(String passwdhash) {
		this.passwdhash = passwdhash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Long getIddetails() {
		return iddetails;
	}

	public void setIddetails(Long iddetails) {
		this.iddetails = iddetails;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (iduser != null ? iduser.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
        return !((this.iduser == null && other.iduser != null)
                || (this.iduser != null && !this.iduser.equals(other.iduser)));
    }

	@Override
	public String toString() {
		return "ua.ibt.jpa.User[ iduser=" + iduser + " ]";
	}

}
