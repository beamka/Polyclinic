package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iryna Tkachova on 12.03.2017.
 */
@XmlRootElement
public class ListPhones extends SysMessage{

    @XmlElement(required = true)
    public List<PhoneAPI> phoneAPI = new ArrayList<>();
}
