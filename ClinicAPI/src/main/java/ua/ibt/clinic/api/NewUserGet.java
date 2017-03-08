package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Iryna Tkachova
 *
 */
@XmlRootElement
public class NewUserGet {

    @XmlElement(required = true)
    public String login;

    @XmlElement(required = true)
    public String passwdhash;

    @XmlElement(required = true)
    public String email;

    @XmlElement
    public String numcard;

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
}
