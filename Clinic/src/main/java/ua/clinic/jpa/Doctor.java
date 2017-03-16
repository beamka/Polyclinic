/**
 *
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * @author Iryna Tkachova
 */
@Entity
@Table(name = "doctor")
//@NamedQueries({@NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM doctor d")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_doctor")
    private Long iddoctor;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_details", referencedColumnName = "id_details")
    private Userdetails userdetails;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "doctor_specialty", joinColumns =
    @JoinColumn(name = "id_doctor"),
            inverseJoinColumns = @JoinColumn(name = "id_specialty"))
    private List<Specialty> specialties;

//    @ManyToOne(optional = false)
//    @JoinColumn(name = "id_graphic", referencedColumnName = "id_graphic")
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "graphic_doctor", joinColumns =
    @JoinColumn(name = "id_doctor"),
            inverseJoinColumns = @JoinColumn(name = "id_doctor"))
    private List<Graphic> graphics;

    public Doctor() {

    }

    public Doctor(Long iddoctor) {

        this.iddoctor = iddoctor;
    }

    public Doctor(Long iddoctor, Userdetails userdetails, List<Specialty> specialties, List<Graphic> graphic) {
        this.iddoctor = iddoctor;
        this.userdetails = userdetails;
        this.specialties = specialties;
        this.graphics = graphic;
    }

    public Userdetails getUserdetails() {
        return userdetails;
    }

    public void setUserdetails(Userdetails userdetails) {
        this.userdetails = userdetails;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Long getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Long iddoctor) {
        this.iddoctor = iddoctor;
    }

    public List<Specialty> getSpecialtyCode() {
        return specialties;
    }

    public void setSpecialtyCode(List<Specialty> specialty) {
        this.specialties = specialty;
    }

    public List<Graphic> getGraphic() {
        return graphics;
    }

    public void setGraphic(List<Graphic> graphic) {
        this.graphics = graphic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddoctor != null ? iddoctor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Doctor)) {
            return false;
        }
        Doctor other = (Doctor) object;
        return !((this.iddoctor == null && other.iddoctor != null)
                || (this.iddoctor != null && !this.iddoctor.equals(other.iddoctor)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.Doctor[ iddoctor=" + iddoctor + " ]";
    }

}
