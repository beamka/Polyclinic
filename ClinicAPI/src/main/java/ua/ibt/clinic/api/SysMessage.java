package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Iryna Tkachova on 07.03.2017.
 */
public class SysMessage {
    @XmlElement(required = true)
    public Integer retcode = 0;
    @XmlElement(required = true)
    public String apiVer = "0.0.1";
    @XmlElement(required = false)
    public String sys_message;
}
