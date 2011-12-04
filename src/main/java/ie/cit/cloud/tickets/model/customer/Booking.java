package ie.cit.cloud.tickets.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import ie.cit.cloud.tickets.model.performance.Event;

@Entity
@Table(name = "BOOKING")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Booking
{
	public static final int INVALID_BOOKING_ID = -1;
	
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String user;
	
	@NotNull
	@OneToOne
	private Event event;
	
	@Min(value = 1)
	private Integer numTickets = 0;
	
	public Booking()
	{
		
	}
	
	public Booking(final String user, final Event event, final Integer numTickets)
	{
		this.user = user;
		this.event = event;
		this.numTickets = numTickets;
	}

	public final Long getId()
	{
		return id;
	}
	
	public final String getUser()
	{
		return user;
	}

	public final void setUser(final String user)
	{
		this.user = user;
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
		return user.hashCode() + event.hashCode();
	}
	
	public boolean equals(final Object other)
	{
		if(other != null && other instanceof Booking)
		{
			final Booking otherBooking = (Booking)other;
			return user.equals(otherBooking.getUser()) && event.equals(otherBooking.getEvent());
		}
		return false;
	}
}
