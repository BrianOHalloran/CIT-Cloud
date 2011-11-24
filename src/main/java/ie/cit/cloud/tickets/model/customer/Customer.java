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
@Table(name = "CUSTOMER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Customer
{
	@Id
	@GeneratedValue
	private Long id;

	@Basic
	@NotEmpty
	private String name;

	@Basic
	@NotEmpty
	private String phoneNumber;

	@Basic
	private String creditCard;

	@Basic
	@NotEmpty
	private String username;

	@Basic
	@NotEmpty
	private String password;

	public Customer()
	{

	}

	public Customer(final Long id, final String name, final String phoneNumber, final String creditCard)
	{
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.creditCard = creditCard;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getCreditCard()
	{
		return creditCard;
	}

	public void setCreditCard(final String creditCard)
	{
		this.creditCard = creditCard;
	}

	public String getUsername()
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

	public int hashCode()
	{
		return name.hashCode() + phoneNumber.hashCode() + username.hashCode() + password.hashCode();
	}

	public boolean equals(final Object other)
	{
		if(other instanceof Customer)
		{
			final Customer otherCustomer = (Customer)other;
			return name.equals(otherCustomer.getName()) && 
					phoneNumber.equals(otherCustomer.getPhoneNumber()) && 
					username.equals(otherCustomer.getUsername()) && 
					password.equals(otherCustomer.getPassword());
		}
		return false;
	}

}
