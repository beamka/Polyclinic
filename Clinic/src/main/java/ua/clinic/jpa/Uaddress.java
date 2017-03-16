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
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 */
@Entity
@Table(name = "address")
//@NamedQueries({@NamedQuery(name = "Uaddress.findAll", query = "SELECT a FROM addres a")})
public class Uaddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_address")
    private Long idaddress;

    @Size(max = 20)
    @Column(name = "country")
    private String country;

    @Size(max = 20)
    @Column(name = "city")
    private String city;

    @Size(max = 20)
    @Column(name = "street")
    private String street;

    @Size(max = 20)
    @Column(name = "numhouse")
    private String numhouse;

    @Size(max = 20)
    @Column(name = "hull")
    private String hull;

    @Size(max = 20)
    @Column(name = "flat")
    private String flat;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_details", referencedColumnName = "id_details")
    private Userdetails userdetails;

    public Uaddress() {

    }

    public Uaddress(Long idaddress) {
        this.idaddress = idaddress;
    }

    public Uaddress(Long idaddress, String country, String city, String street, String numhouse, String hull,
                    String flat) {
        this.idaddress = idaddress;
        this.country = country;
        this.city = city;
        this.street = street;
        this.numhouse = numhouse;
        this.hull = hull;
        this.flat = flat;
    }

    public Long getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Long idaddress) {
        this.idaddress = idaddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumhouse() {
        return numhouse;
    }

    public void setNumhouse(String numhouse) {
        this.numhouse = numhouse;
    }

    public String getHull() {
        return hull;
    }

    public void setHull(String hull) {
        this.hull = hull;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
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
        hash += (idaddress != null ? idaddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Uaddress)) {
            return false;
        }
        Uaddress other = (Uaddress) object;
        return !((this.idaddress == null && other.idaddress != null)
                || (this.idaddress != null && !this.idaddress.equals(other.idaddress)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.Uaddress[ idaddress=" + idaddress + " ]";
    }

}
