package ua.clinic.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Iryna Tkachova on 04.03.2017.
 */
@Entity
@Table(name = "specialtyname")
//@NamedQueries({@NamedQuery(name = "SpecialtyName.findAll", query = "SELECT s FROM specialtyname s")})
public class SpecialtyName implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_code")
    private Long idcode;

    @Size(max = 20)
    @Column(name = "name_specialty")
    private String namespecialty;

    public SpecialtyName() {

    }

    public SpecialtyName(Long idcode) {
        this.idcode = idcode;
    }

    public SpecialtyName(Long idcode, String namespecialty) {
        this.idcode = idcode;
        this.namespecialty = namespecialty;
    }

    public Long getIdcode() {
        return idcode;
    }

    public void setIdcode(Long idcode) {
        this.idcode = idcode;
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
        hash += (idcode != null ? idcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SpecialtyName)) {
            return false;
        }
        SpecialtyName other = (SpecialtyName) object;
        return !((this.idcode == null && other.idcode != null)
                || (this.idcode != null && !this.idcode.equals(other.idcode)));
    }

    @Override
    public String toString() {
        return "ua.ibt.jpa.SpecialtyName[ idcode=" + idcode + " ]";
    }
}
