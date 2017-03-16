/**
 * 
 */
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
public class UserAPI {
	@XmlElement
	public Long id_user;

	@XmlElement
	public Long id_details;

	@XmlElement
	public String login;

	@XmlElement
	public String passwdhash;

	@XmlElement
	public String email;

	@XmlElement
	public String createdby;

	@XmlElement
	public Date lastlogin;

	@XmlElement(required = true)
	public List<GroupAPI> groupAPIS = new ArrayList<>();

}
