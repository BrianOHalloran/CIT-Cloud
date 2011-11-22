package ie.cit.cloud.tickets.model.customer;

import java.util.UUID;

import ie.cit.cloud.tickets.model.performance.Event;

public class Booking
{
	private String id;
	private Customer customer;
	private Event event;
	
	public Booking(final Customer customer, final Event event)
	{
		this(UUID.randomUUID().toString(), customer, event);
	}
	
	private Booking(final String id, final Customer customer, final Event event)
	{
		this.id = id;
		this.customer = customer;
		this.event = event;
	}

	public final String getId()
	{
		return id;
	}

	public final void setId(final String id)
	{
		this.id = id;
	}

	public final Customer getCustomer()
	{
		return customer;
	}

	public final void setCustomer(final Customer customer)
	{
		this.customer = customer;
	}

	public final Event getEvent()
	{
		return event;
	}

	public final void setEvent(final Event event)
	{
		this.event = event;
	}

	
}
