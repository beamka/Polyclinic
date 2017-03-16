package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@XmlRootElement
public class SpecialtyAPI {

    @XmlElement
    public Long idspecialty;

    @XmlElement
    public String codespecialty;

    @XmlElement
    public String namespecialty;
}
