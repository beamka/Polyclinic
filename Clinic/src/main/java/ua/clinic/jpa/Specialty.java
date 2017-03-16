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
@Table(name = "specialty")
//@NamedQueries({@NamedQuery(name = "Specialty.findAll", query = "SELECT s FROM specialty s")})
public class Specialty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id_specialty")
    private Long idspecialty;

    @Size(max = 3)
    @Column(name = "code_specialty")
    private Long codespecialty;

    @Size(max = 20)
    @Column(name = "name_specialty")
    private String namespecialty;

    @ManyToMany
    @JoinTable(name = "doctor_specialty", joinColumns =
    @JoinColumn(name = "id_specialty"),
            inverseJoinColumns = @JoinColumn(name = "id_doctor"))
    private List<Doctor> doctors;

    public Specialty() {

    }

    public Specialty(Long idspecialty) {

        this.idspecialty = idspecialty;
    }

    public Specialty(Long idspecialty, Long codespecialty) {
        this.idspecialty = idspecialty;
        this.codespecialty = codespecialty;
    }

    public Long getIdspecialty() {
        return idspecialty;
    }

    public void setIdspecialty(Long idspecialty) {
        this.idspecialty = idspecialty;
    }

    public Long getCodespecialty() {
        return codespecialty;
    }

    public void setCodespecialty(Long codespecialty) {
        this.codespecialty = codespecialty;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getNamespecialty() {
        return namespecialty;
    }

    public void setNamespecialty(String namespecialty) {
        this.namespecialty = namespecialty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspecialty != null ? idspecialty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Specialty)) {
            return false;
        }
        Specialty other = (Specialty) object;
        return !((this.idspecialty == null && other.idspecialty != null)
                || (this.idspecialty != null && !this.idspecialty.equals(other.idspecialty)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.Specialty[ idspecialty=" + idspecialty + " ]";
    }

}
