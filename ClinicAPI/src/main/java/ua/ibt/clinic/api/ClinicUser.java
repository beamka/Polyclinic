/**
 * 
 */
package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Iryna Tkachova
 *
 */
@XmlRootElement
public class ClinicUser {
	@XmlElement
	public Long user_id;

	@XmlElement(required = true)
	public String login;

	@XmlElement(required = true)
	public String passwdhash;

	@XmlElement(required = true)
	public String email;

	@XmlElement
	private String createdby;

	@XmlElement
	private String lastlogin;

	@XmlElement(required = true)
	public String firstName;

	@XmlElement(required = true)
	public String lastName;

	@XmlElement
	public String numcard;

}
