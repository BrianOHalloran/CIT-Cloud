package ie.cit.cloud.tickets.model.customer;

import javax.persistence.Basic;
import javax.persistence.Entity;
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
	private Long id;
	
	@Basic
	@NotEmpty
	private String name;
	
	@Basic
	private String phoneNumber;

	@Basic
	private String creditCard;
	
	public Customer()
	{
		
	}
	
	public Customer(final String name, final String phoneNumber, final String creditCard)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.creditCard = creditCard;
	}

	public final Long getId()
	{
		return id;
	}

	public final void setId(final Long id)
	{
		this.id = id;
	}

	public final String getName()
	{
		return name;
	}

	public final void setName(final String name)
	{
		this.name = name;
	}

	public final String getPhoneNumber()
	{
		return phoneNumber;
	}

	public final void setPhoneNumber(final String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public final String getCreditCard()
	{
		return creditCard;
	}

	public final void setCreditCard(final String creditCard)
	{
		this.creditCard = creditCard;
	}

	
}
