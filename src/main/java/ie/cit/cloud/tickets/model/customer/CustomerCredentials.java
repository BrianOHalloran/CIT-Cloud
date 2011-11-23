package ie.cit.cloud.tickets.model.customer;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CUSTOMER_CREDENTIALS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CustomerCredentials
{
	@Id
	@GeneratedValue
	private String id;

	@Basic
	@NotEmpty
	private String username;
	
	@Basic
	@NotEmpty
	private String password;
	
	@Basic
	private String creditCard;
	
	public CustomerCredentials()
	{

	}

	public String getId()
	{
		return id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}

	public  String getUsername()
	{
		return username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public String getCreditCard()
	{
		return creditCard;
	}

	public void setCreditCard(final String creditCard)
	{
		this.creditCard = creditCard;
	}
	
	
}
