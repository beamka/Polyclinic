package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Iryna Tkachova
 *
 */
public class AddUserRequest {
	@XmlElement(required = true)
	public UserAPI user;
}