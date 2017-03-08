package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Iryna Tkachova
 *
 */
@XmlRootElement
public class ListUsersReceive extends SysMessage {

    @XmlElement(required = true)
    public List<ClinicUser> users = new ArrayList<>();
}
