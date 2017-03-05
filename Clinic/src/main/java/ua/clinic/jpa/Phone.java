/**
 * 
 */
package ua.clinic.jpa;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 *
 */
@Entity
@Table(name = "phone")
//@NamedQueries({ @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM phone p") })
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_phone")
	private Long idphone;

	@Size(max = 20)
	@Column(name = "phone")
	private String phone;

	@Size(max = 20)
	@Column(name = "phoneinfo")
	private String phoneinfo;

	//@JoinColumn(name = "id_phone", referencedColumnName = "id_details")
	@ManyToOne(optional = false)
	private Userdetails userdetails;

	public Phone() {

	}

	public Phone(Long idphone) {
		this.idphone = idphone;
	}

	public Phone(Long idphone, String phone, String phoneinfo) {
		super();
		this.idphone = idphone;
		this.phone = phone;
		this.phoneinfo = phoneinfo;
	}

	public Long getIdphone() {
		return idphone;
	}

	public void setIdphone(Long idphone) {
		this.idphone = idphone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoneinfo() {
		return phoneinfo;
	}

	public void setPhoneinfo(String phoneinfo) {
		this.phoneinfo = phoneinfo;
	}

	public Userdetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Userdetails userdetails) {
		this.userdetails = userdetails;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idphone != null ? idphone.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Phone)) {
			return false;
		}
		Phone other = (Phone) object;
        return !((this.idphone == null && other.idphone != null)
                || (this.idphone != null && !this.idphone.equals(other.idphone)));
    }

	@Override
	public String toString() {
		return "ua.ibt.jpa.Phone[ idphone=" + idphone + " ]";
	}

}
