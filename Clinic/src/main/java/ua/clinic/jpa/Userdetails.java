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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NotNull
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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "notes")
    private String notes;

    @JoinColumn(name = "id_details", referencedColumnName = "id_user", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userdetails")
    private List<Address> address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userdetails")
    private List<Phone> phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userdetails")
    private List<Visit> visits;

    public Userdetails() {

    }

    public Userdetails(Long iddetails) {
        this.iddetails = iddetails;
    }

    public Userdetails(Long iddetails, String numcard, String name, String surname, String middlename, Date birthday,
                       String sex, String notes) {
        this.iddetails = iddetails;
        this.numcard = numcard;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.sex = sex;
        this.notes = notes;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
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
