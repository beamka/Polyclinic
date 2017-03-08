package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Tkachova on 08.03.2017.
 */
@XmlRootElement
public class ListGroupReceive extends SysMessage{

    @XmlElement(required = true)
    public List<Group> groups = new ArrayList<>();
}
