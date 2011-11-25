package ie.cit.cloud.tickets.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import ie.cit.cloud.tickets.model.performance.Event;

@Entity
@Table(name = "BOOKING")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Booking
{
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@OneToOne
	private Customer customer;
	
	@NotEmpty
	@OneToOne
	private Event event;
	
	@NotEmpty
	private int numTickets = 0;
	
	public Booking()
	{
		
	}
	
	private Booking(final Customer customer, final Event event)
	{
		this.customer = customer;
		this.event = event;
	}

	public final Long getId()
	{
		return id;
	}

	public final void setId(final Long id)
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

	public int getNumTickets()
	{
		return numTickets;
	}

	public void setNumTickets(final int numTickets)
	{
		this.numTickets = numTickets;
	}

	public int hashCode()
	{
		return customer.hashCode() + event.hashCode();
	}
	
	public boolean equals(final Object other)
	{
		if(other instanceof Booking)
		{
			final Booking otherBooking = (Booking)other;
			return customer.equals(otherBooking.getCustomer()) && event.equals(otherBooking.getEvent());
		}
		return false;
	}
}
