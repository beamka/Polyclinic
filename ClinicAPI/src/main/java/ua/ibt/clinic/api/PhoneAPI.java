package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@XmlRootElement
public class PhoneAPI extends SysMessage{

    @XmlElement
    public Long iduser;

    @XmlElement
    public Long idphone;

    @XmlElement
    public String phone;

    @XmlElement
    public String phoneinfo;
}
