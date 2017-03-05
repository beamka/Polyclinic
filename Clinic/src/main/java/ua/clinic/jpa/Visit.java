/**
 * 
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 *
 */
@Entity
@Table(name = "visit")
//@NamedQueries({ @NamedQuery(name = "Visit.findAll", query = "SELECT v FROM Visit v") })
public class Visit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_visit")
	private Long idvisit;

	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Size(max = 20)
	@Column(name = "weekday")
	private String weekday;

	@Size(max = 20)
	@Column(name = "time")
	private String time;

	@Size(max = 20)
	@Column(name = "info")
	private String info;

	//@JoinColumn(name = "id_visit", referencedColumnName = "id_details")
	@ManyToOne(optional = false)
	private Userdetails userdetails;

	//@JoinColumn(name = "id_visit", referencedColumnName = "id_doctor")
	@ManyToOne(optional = false)
	private Doctor doctor;

	public Visit() {

	}

	public Visit(Long idvisit) {
		this.idvisit = idvisit;
	}

	public Visit(Long idvisit, Date date, String weekday, String time, String info) {
		this.idvisit = idvisit;
		this.date = date;
		this.weekday = weekday;
		this.time = time;
		this.info = info;
	}

	public Long getIdvisit() {
		return idvisit;
	}

	public void setIdvisit(Long idvisit) {
		this.idvisit = idvisit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Userdetails getUserdetail() {
		return userdetails;
	}

	public void setUserdetail(Userdetails userdetails) {
		this.userdetails = userdetails;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idvisit != null ? idvisit.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Visit)) {
			return false;
		}
		Visit other = (Visit) object;
        return !((this.idvisit == null && other.idvisit != null)
                || (this.idvisit != null && !this.idvisit.equals(other.idvisit)));
    }

	@Override
	public String toString() {
		return "ua.ibt.jpa.Visit[ idvisit=" + idvisit + " ]";
	}

}
