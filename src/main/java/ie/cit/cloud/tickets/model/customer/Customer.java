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
	@NotEmpty
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

	public Customer(final String name, final String phoneNumber, final String creditCard, final String username, final String password)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.creditCard = creditCard;
		this.username = username;
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#getId()
	 */
	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id)
	{
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#getName()
	 */
	public String getName()
	{
		return name;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#setName(java.lang.String)
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#getPhoneNumber()
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#setPhoneNumber(java.lang.String)
	 */
	public void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#getCreditCard()
	 */
	public String getCreditCard()
	{
		return creditCard;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#setCreditCard(java.lang.String)
	 */
	public void setCreditCard(final String creditCard)
	{
		this.creditCard = creditCard;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#getUsername()
	 */
	public String getUsername()
	{
		return username;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#setUsername(java.lang.String)
	 */
	public void setUsername(final String username)
	{
		this.username = username;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#getPassword()
	 */
	public String getPassword()
	{
		return password;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.tickets.model.customer.ICustomer#setPassword(java.lang.String)
	 */
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
		if(other != null && other instanceof Customer)
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
