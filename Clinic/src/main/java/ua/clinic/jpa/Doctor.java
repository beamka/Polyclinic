/**
 *
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Iryna Tkachova
 */
@Entity
@Table(name = "doctor")
//@NamedQueries({@NamedQuery(name = "Doctor.findAll", query = "SELECT d FROM doctor d")})
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_doctor")
    private Long iddoctor;

    @JoinColumn(name = "id_doctor", referencedColumnName = "id_user", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    //@ManyToMany(mappedBy = "doctor")
    @ManyToMany
    private List<SpecialtyCode> specialtyCodes;

    @JoinColumn(name = "id_graphic", referencedColumnName = "id_graphic")
    @ManyToOne(optional = false)
    private Graphic graphic;

    public Doctor() {

    }

    public Doctor(Long iddoctor) {

        this.iddoctor = iddoctor;
    }

    public Doctor(Long iddoctor, User user, List<SpecialtyCode> specialtyCodes, Graphic graphic) {
        this.iddoctor = iddoctor;
        this.user = user;
        this.specialtyCodes = specialtyCodes;
        this.graphic = graphic;
    }

    public Long getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Long iddoctor) {
        this.iddoctor = iddoctor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SpecialtyCode> getSpecialtyCode() {
        return specialtyCodes;
    }

    public void setSpecialtyCode(List<SpecialtyCode> specialtyCode) {
        this.specialtyCodes = specialtyCode;
    }

    public Graphic getGraphic() {
        return graphic;
    }

    public void setGraphic(Graphic graphic) {
        this.graphic = graphic;
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
