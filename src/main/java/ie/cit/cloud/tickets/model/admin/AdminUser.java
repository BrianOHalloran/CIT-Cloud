package ie.cit.cloud.tickets.model.admin;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ADMIN")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AdminUser
{
	@Id
	@GeneratedValue
	private Long id;
	
	@Basic
	@NotEmpty
	private String username;
	
	@Basic
	@NotEmpty
	private String password;

	public AdminUser()
	{
		
	}
	
	public AdminUser(final String username, final String password)
	{
		this.username = username;
		this.password = password;
	}

	public Long getId()
	{
		return id;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}
}
