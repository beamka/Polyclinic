package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Iryna Tkachova on 11.03.2017.
 */
@XmlRootElement
public class DetailsAPI extends SysMessage{

    @XmlElement
    public Long iduser;

    @XmlElement
    public String name;

    @XmlElement
    public String surname;

    @XmlElement
    public String middlename;

    @XmlElement
    public Date birthday;

    @XmlElement
    public String sex;

    @XmlElement
    public String numcard;

    @XmlElement
    public String notes;

    @XmlElement
    public Long id_doctor;

}
