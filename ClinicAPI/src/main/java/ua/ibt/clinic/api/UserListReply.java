package ua.ibt.clinic.api;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Iryna Tkachova
 *
 */
@XmlRootElement
public class UserListReply extends GenericReply {
	@XmlElement(required = true)
	public List<ClinicUser> users = new ArrayList<>();
}