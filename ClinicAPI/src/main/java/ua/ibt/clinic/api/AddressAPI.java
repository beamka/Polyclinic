package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@XmlRootElement
public class AddressAPI extends SysMessage{

    @XmlElement
    public Long iduser;

    @XmlElement
    public Long idaddress;

    @XmlElement
    public String country;

    @XmlElement
    public String city;

    @XmlElement
    public String street;

    @XmlElement
    public String numhouse;

    @XmlElement
    public String hull;

    @XmlElement
    public String flat;
}
