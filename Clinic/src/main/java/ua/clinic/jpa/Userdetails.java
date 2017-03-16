/**
 *
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 */
@Entity
@Table(name = "userdetails")
//@NamedQueries({@NamedQuery(name = "Userdetails.findAll", query = "SELECT u FROM userdetails u")})
public class Userdetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_details")
    private Long iddetails;

    @Size(max = 20)
    @Column(name = "numcard")
    private String numcard;

    @Size(max = 20)
    @Column(name = "name")
    private String name;

    @Size(max = 20)
    @Column(name = "surname")
    private String surname;

    @Size(max = 20)
    @Column(name = "middlename")
    private String middlename;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Size(max = 1) // M F
    @Column(name = "sex")
    private String sex;

    @Size(max = 1000)
    @Column(name = "notes")
    private String notes;

    @Column(name = "id_user")
    private Long iduser;

    @OneToMany(mappedBy = "userdetails", cascade = CascadeType.ALL)
    private List<Uaddress> address;

    @OneToMany(mappedBy = "userdetails", cascade = CascadeType.ALL)
    private List<Uphone> uphones;

    @OneToMany(mappedBy = "userdetails", cascade = CascadeType.ALL)
    private List<Visit> visits;

    @OneToOne(mappedBy = "userdetails", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor")
    private Doctor doctor;

    public Userdetails() {

    }

    public Userdetails(Long iddetails) {

        this.iddetails = iddetails;
    }

    public Userdetails(Long iduser, Long iddetails, String numcard, String name, String surname, String middlename, Date birthday,
                       String sex, String notes) {
        this.iduser = iduser;
        this.iddetails = iddetails;
        this.numcard = numcard;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.sex = sex;
        this.notes = notes;
    }

    public List<Uphone> getUphones() {
        return uphones;
    }

    public void setUphones(List<Uphone> uphones) {
        this.uphones = uphones;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Long getIddetails() {
        return iddetails;
    }

    public void setIddetails(Long iddetails) {
        this.iddetails = iddetails;
    }

    public String getNumcard() {
        return numcard;
    }

    public void setNumcard(String numcard) {
        this.numcard = numcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public List<Uaddress> getAddres() {
        return address;
    }

    public void setAddres(List<Uaddress> addres) {
        this.address = addres;
    }

    public List<Uphone> getPhone() {
        return uphones;
    }

    public void setPhone(List<Uphone> uphone) {
        this.uphones = uphone;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetails != null ? iddetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Userdetails)) {
            return false;
        }
        Userdetails other = (Userdetails) object;
        return !((this.iddetails == null && other.iddetails != null)
                || (this.iddetails != null && !this.iddetails.equals(other.iddetails)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.Userdetails[ iddetails=" + iddetails + " ]";
    }

}
