/**
 * 
 */
package ua.ibt.clinic.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Iryna Tkachova
 *
 */
@XmlRootElement
public class ClinicUser {
	@XmlElement
	public Long user_id;

	@XmlElement
	public String login;

	@XmlElement
	public String passwdhash;

	@XmlElement
	public String email;

	@XmlElement
	public String createdby;

	@XmlElement
	public String lastlogin;

	@XmlElement
	public String name;

	@XmlElement
	public String surname;

	@XmlElement
	public String middlename;

	@XmlElement
	public Date birthday;

	@XmlElement
	public String sex;

	@XmlElement
	public String numcard;

}
