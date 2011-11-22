package ie.cit.cloud.tickets.model.customer;

import java.util.UUID;

public class Customer
{
	private String id;
	private String name;
	private String phoneNumber;
	
	public Customer(final String name, final String phoneNumber)
	{
		this(UUID.randomUUID().toString(), name, phoneNumber);
	}

	public Customer(final String id, final String name, final String phoneNumber)
	{
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public final String getId()
	{
		return id;
	}

	public final void setId(final String id)
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
}
