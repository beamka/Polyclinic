/**
 *
 */
package ua.clinic.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Iryna Tkachova
 */
@Entity
@Table(name = "graphic")
//@NamedQueries({@NamedQuery(name = "Graphic.findAll", query = "SELECT g FROM graphic g")})
public class Graphic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_graphic")
    private Long idgraphic;

    @Size(max = 20)
    @Column(name = "time")
    private String time;

    @Size(max = 20)
    @Column(name = "weekday")
    private String weekday;

    @Size(max = 4)
    @Column(name = "cabinet")
    private String cabinet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "graphic")
    private List<Doctor> Doctors;

    public Graphic() {

    }

    public Graphic(Long idgraphic) {
        this.idgraphic = idgraphic;
    }

    public Graphic(Long idgraphic, String time, String weekday, String cabinet) {
        super();
        this.idgraphic = idgraphic;
        this.time = time;
        this.weekday = weekday;
        this.cabinet = cabinet;
    }

    public Long getIdgraphic() {
        return idgraphic;
    }

    public void setIdgraphic(Long idgraphic) {
        this.idgraphic = idgraphic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public List<Doctor> getDoctors() {
        return Doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        Doctors = doctors;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgraphic != null ? idgraphic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Graphic)) {
            return false;
        }
        Graphic other = (Graphic) object;
        return !((this.idgraphic == null && other.idgraphic != null)
                || (this.idgraphic != null && !this.idgraphic.equals(other.idgraphic)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.Graphic[ idgraphic=" + idgraphic + " ]";
    }

}
