package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@XmlRootElement
public class GraphicAPI extends SysMessage{
    @XmlElement
    public Long iduser;

    @XmlElement
    public String time;

    @XmlElement
    public String weekday;

    @XmlElement
    public String cabinet;

}
