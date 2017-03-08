package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Iryna Tkachova on 08.03.2017.
 */
@XmlRootElement
public class Group {
    @XmlElement
    public Long group_id;

    @XmlElement
    public String group_name;

    @XmlElement
    public String description;
}
